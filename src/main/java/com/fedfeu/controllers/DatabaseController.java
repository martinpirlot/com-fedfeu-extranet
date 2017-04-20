package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Cup;
import com.fedfeu.beans.Member;
import com.fedfeu.database.ClubRepository;
import com.fedfeu.database.CupRepository;
import com.fedfeu.database.MemberRepository;

@Service
public class DatabaseController implements Serializable {
	private static final long serialVersionUID = 2799171946572973592L;

	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private CupRepository cupRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	public Map<String, Object> getClubsMap() {
		Iterable<Club> clubIterable = clubRepository.findAll();
		Map<String, Object> clubMap = new LinkedHashMap<String, Object>();

		for (Club club : clubIterable) {
			clubMap.put(club.getName(), club);
		}

		return clubMap;
	}
	
	public Club getClub(long clubId) {
		Club club = null;
		try {
			club = clubRepository.findOne(clubId);
		} catch (Exception e) {
		}

		return club;
	}
	
	public Cup getCup(long cupId) {
		Cup cup = null;
		try {
			cup = cupRepository.findOne(cupId);
		} catch (Exception e) {
		}
		
		return cup;
	}
	
	public Member getMember(long memberId) {
		Member member = null;
		try {
			member = memberRepository.findOne(memberId);
		} catch (Exception e) {
		}
		
		return member;
	}
	
	public void saveMember(Member member) {
		memberRepository.save(member);
	}
	
	public Map<String, Object> getMembersOfClubMap(long clubId) {

		Map<String, Object> memberMap = new LinkedHashMap<String, Object>();
		if(clubId != -1)
			return memberMap;
		
		Iterable<Member> memberIterable = memberRepository.findAll();
		
		for(Member member : memberIterable) {
			memberMap.put(member.getFirstName() + " " + member.getLastName(), member);
		}
		
		return memberMap;
	}
}

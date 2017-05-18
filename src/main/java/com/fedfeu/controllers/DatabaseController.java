package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Cup;
import com.fedfeu.beans.Member;
import com.fedfeu.beans.Result;
import com.fedfeu.database.ClubRepository;
import com.fedfeu.database.CupRepository;
import com.fedfeu.database.MemberRepository;
import com.fedfeu.database.ResultRepository;
import com.fedfeu.utils.Utils;

@Service
public class DatabaseController implements Serializable {
	private static final long serialVersionUID = 2799171946572973592L;

	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private CupRepository cupRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ResultRepository resultRepository;

	public Map<String, Object> getClubsMap() {
		Iterable<Club> clubIterable = clubRepository.findAll();
		Map<String, Object> clubMap = new LinkedHashMap<String, Object>();

		for (Club club : clubIterable) {
			clubMap.put(club.getName(), club);
		}

		return clubMap;
	}
	
	public ArrayList<Club> getClubList() {
		return Utils.makeList(clubRepository.findAll());
	}
	
	public ArrayList<Cup> getCupList() {
		return Utils.makeList(cupRepository.findAll());
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
	
	public ArrayList<Member> getMemberList() {
		return Utils.makeList(memberRepository.findAll());
	}
	
	public void saveMember(Member member) {
		memberRepository.save(member);
	}
	
	public void saveClub(Club club) {
		clubRepository.save(club);
	}
	
	public void saveCup(Cup cup) {
		cupRepository.save(cup);
	}
	
	public void saveResult(Result result) {
		resultRepository.save(result);
	}
	
	public Map<String, Object> getMembersOfClubMap(long clubId) {

		Map<String, Object> memberMap = new LinkedHashMap<String, Object>();
		
		Iterable<Member> memberIterable = memberRepository.findAll();
		
		for(Member member : memberIterable) {
			memberMap.put(member.toString(), member);
		}
		
		return memberMap;
	}
}

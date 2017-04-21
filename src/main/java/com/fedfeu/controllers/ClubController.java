package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Member;

@Component
@Scope("request")
public class ClubController implements Serializable {
	private static final long serialVersionUID = 2272588195135381178L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
	@Autowired
    private DatabaseController databaseController;
	
	private long clubId;
	private Club club = null;
	ArrayList<Member> memberList;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	public String getRequestContextPath() {
		return externalContext.getRequestContextPath();
	}
	
	public String addClub() {
		System.out.println(club.getName());
		System.out.println(club.getWebsite());
		System.out.println(club.getPresident());
		System.out.println(club.getMailContact());
		System.out.println(club.getAddress().getStreet());
		System.out.println(club.getAddress().getPostCode());
		System.out.println(club.getAddress().getCity());
		System.out.println(club.getAddress().getCountry());

		databaseController.saveClub(club);
		return null;
	}
	
	public String updateClub() {
		return null;
	}
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		String sClubId = request.getParameter("clubId");
		if(sClubId != null) {
			try {
				clubId = Long.parseLong(sClubId);
				club = databaseController.getClub(clubId);
			} catch (Exception e) {
			}
		}
		
		if(club == null) {
			clubId = -1;
			club = new Club();
		}
		
		memberList = databaseController.getMemberList();
	}
	
	public Club getClub() {
		return club;
	}
	
	public void setClub(Club club) {
		this.club = club;
	}
	
	public ArrayList<Member> getMembersOfClubMap() {
		return memberList;
	}
}

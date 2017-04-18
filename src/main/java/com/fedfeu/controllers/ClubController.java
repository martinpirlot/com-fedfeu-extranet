package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Member;
import com.fedfeu.database.MySQLDatabase;

@ManagedBean
@RequestScoped	
public class ClubController implements Serializable {
	private static final long serialVersionUID = 2272588195135381178L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
	private String clubId = null;
	private Club club = null;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	public String getRequestContextPath() {
		return externalContext.getRequestContextPath();
	}
	
	public String addClub() {
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
		
		clubId = request.getParameter("clubId");
		
		if(clubId != null)
			club = MySQLDatabase.getClub(clubId);
	}
	
	public Club getClub() {
		return club;
	}
	
	public void setClub(Club club) {
		this.club = club;
	}
	
	public Map<String, Object> getMemberMap() {

		Map<String, Object> memberMap = new LinkedHashMap<String, Object>();
		if(clubId == null)
			return memberMap;
		
		List<Member> memberList = MySQLDatabase.getMemberList(clubId);
		
		for(Member member : memberList) {
			memberMap.put(member.getFirstName() + " " + member.getLastName(), member);
		}
		
		return memberMap;
	}
}

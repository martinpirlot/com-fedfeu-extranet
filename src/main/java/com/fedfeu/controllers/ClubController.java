package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.fedfeu.beans.Address;
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
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		clubId = request.getParameter("id");
		
		if(clubId != null)
			club = MySQLDatabase.getClub(clubId);
	}
	
	public String getId() {
		if(club != null)
			return club.getId();
		else
			return "";
	}
	
	public String getName() {
		if(club != null)
			return club.getName();
		else
			return "";
	}
	
	public String getWebsite() {
		if(club != null)
			return club.getWebsite();
		else
			return "";
	}
	
	public Member getPresident() {
		if(club != null)
			return club.getPresident();
		else
			return new Member();
	}
	
	public String getMailContact() {
		if(club != null)
			return club.getMailContact();
		else
			return "";
	}
	
	public Address getAddress() {
		if(club != null)
			return club.getAddress();
		else
			return new Address();
	}
}

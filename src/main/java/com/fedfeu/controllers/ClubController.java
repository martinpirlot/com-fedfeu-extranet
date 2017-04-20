package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fedfeu.beans.Club;

@Component
@Scope("request")
public class ClubController implements Serializable {
	private static final long serialVersionUID = 2272588195135381178L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private DatabaseController databaseController;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	private long clubId;
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
		databaseController = (DatabaseController) applicationContext.getBean("databaseController");
		
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
	}
	
	public Club getClub() {
		return club;
	}
	
	public void setClub(Club club) {
		this.club = club;
	}
	
	public Map<String, Object> getMembersOfClubMap() {
		return databaseController.getMembersOfClubMap(clubId);
	}
}

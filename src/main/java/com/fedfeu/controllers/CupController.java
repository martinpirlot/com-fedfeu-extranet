package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fedfeu.beans.Cup;

@Component
@Scope("request")
public class CupController implements Serializable {
	private static final long serialVersionUID = 1467376062016242709L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;

	@Autowired
    private DatabaseController databaseController;
	
	private long cupId;
	private Cup cup = null;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	public String getRequestContextPath() {
		return externalContext.getRequestContextPath();
	}
	
	public String addCup() {
		System.out.println(cup.getName());
		System.out.println(cup.getStartDate());
		System.out.println(cup.getEndDate());
		System.out.println(cup.getClub());
		System.out.println(cup.getAddress().getStreet());
		System.out.println(cup.getAddress().getPostCode());
		System.out.println(cup.getAddress().getCity());
		System.out.println(cup.getAddress().getCountry());
		System.out.println("h:" + cup.isHighJump());
		System.out.println("tj:" + cup.isTripleJump());
		System.out.println("fss:" + cup.isFreestyleStreet());

		databaseController.saveCup(cup);
		return null;
	}
	
	public String updateCup() {
		return null;
	}
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		String sCupId = request.getParameter("cupId");
		if(sCupId != null) {
			try {
				cupId = Long.parseLong(sCupId);
				cup = databaseController.getCup(cupId);
			} catch (Exception e) {
			}
		}

		if(cup == null) {
			cupId = -1;
			cup = new Cup();
		}
	}
	
	public Cup getCup() {
		return cup;
	}
	
	public void setCup(Cup cup) {
		this.cup = cup;
	}
	
	public Map<String, Object> getClubsMap() {
		return databaseController.getClubsMap();
	}
}

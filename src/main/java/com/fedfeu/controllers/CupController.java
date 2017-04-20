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

import com.fedfeu.beans.Cup;

@Component
@Scope("request")
public class CupController implements Serializable {
	private static final long serialVersionUID = 1467376062016242709L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private DatabaseController databaseController;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	private long cupId;
	private Cup cup = null;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	public String getRequestContextPath() {
		return externalContext.getRequestContextPath();
	}
	
	public String addCup() {
		return null;
	}
	
	public String updateCup() {
		return null;
	}
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		databaseController = (DatabaseController) applicationContext.getBean("databaseController");
		
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

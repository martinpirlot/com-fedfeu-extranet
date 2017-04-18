package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.fedfeu.beans.Cup;
import com.fedfeu.database.MySQLDatabase;

@ManagedBean
@RequestScoped	
public class CupController implements Serializable {
	private static final long serialVersionUID = 1467376062016242709L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
	private String cupId = null;
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
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		cupId = request.getParameter("cupId");
		
		if(cupId != null)
			cup = MySQLDatabase.getCup(cupId);
	}
	
	public Cup getCup() {
		return cup;
	}
	
	public void setCup(Cup cup) {
		this.cup = cup;
	}
}

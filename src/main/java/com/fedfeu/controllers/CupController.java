package com.fedfeu.controllers;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.fedfeu.beans.Address;
import com.fedfeu.beans.Club;
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
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		cupId = request.getParameter("id");
		
		if(cupId != null)
			cup = MySQLDatabase.getCup(cupId);
	}
	
	public String getId() {
		if(cup != null)
			return cup.getId();
		else
			return "";
	}
	
	public String getName() {
		if(cup != null)
			return cup.getName();
		else
			return "";
	}
	
	public Date getStartDate() {
		if(cup != null)
			return cup.getStartDate();
		else
			return null;
	}
	
	public Date getEndDate() {
		if(cup != null)
			return cup.getEndDate();
		else
			return null;
	}
	
	public Club getClub() {
		if(cup != null)
			return cup.getClub();
		else
			return new Club();
	}
	
	public Address getAddress() {
		if(cup != null)
			return cup.getAddress();
		else
			return new Address();
	}
	
	public List<String> getTypeList() {
		if(cup != null)
			return cup.getTypeList();
		else
			return new ArrayList<String>();
	}
}

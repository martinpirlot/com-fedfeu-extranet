package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fedfeu.beans.Club;
import com.fedfeu.database.MySQLDatabase;

@ManagedBean
@SessionScoped	
public class HomePageController implements Serializable {
	private static final long serialVersionUID = 3029415546214855090L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
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
	}
	
	public Map<String, Object> getClubMap() {
		List<Club> clubList = MySQLDatabase.getClubList();
		Map<String, Object> clubMap = new LinkedHashMap<String, Object>();
		
		for(Club club : clubList) {
			clubMap.put(club.getName(), club);
		}
		
		return clubMap;
	}
}

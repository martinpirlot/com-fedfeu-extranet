package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped	
public class HomePageController implements Serializable {
	private static final long serialVersionUID = -7500516416605360397L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
	}
}

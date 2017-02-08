package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserSessionController implements Serializable {
	private static final long serialVersionUID = -7500516416605360397L;

	private String userName;
	private FacesContext facesContext;
	private ExternalContext externalContext;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		if (getUserName().equals("admin")) {
			return true;
		}
		return false;
	}

	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();

		setUserName(externalContext.getRemoteUser());
	}
}

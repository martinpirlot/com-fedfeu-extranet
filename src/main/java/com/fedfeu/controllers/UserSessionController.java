package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UserSessionController implements Serializable {
	private static final long serialVersionUID = 6222608349626082143L;
	
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

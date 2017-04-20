package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
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
}

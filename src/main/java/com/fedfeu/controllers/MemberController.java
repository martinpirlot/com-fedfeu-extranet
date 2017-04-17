package com.fedfeu.controllers;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.fedfeu.beans.Address;
import com.fedfeu.beans.Club;
import com.fedfeu.beans.Member;
import com.fedfeu.database.MySQLDatabase;

@ManagedBean
@RequestScoped
public class MemberController implements Serializable {
	private static final long serialVersionUID = -3700388372648488221L;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	
	private String memberId = null;
	private Member member = null;
	
	public String getContextPath() {
		return externalContext.getApplicationContextPath();
	}
	
	public String getRequestContextPath() {
		return externalContext.getRequestContextPath();
	}
	
	public String addMember() {
		return null;
	}
	
	public String updateMember() {
		return null;
	}
	
	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		memberId = request.getParameter("id");
		
		if(memberId != null)
			member = MySQLDatabase.getMember(memberId);
	}
	
	public long getId() {
		if(member != null)
			return member.getId();
		else
			return -1;
	}
	
	public String getFirstName() {
		if(member != null)
			return member.getFirstName();
		else
			return "";
	}
	
	public String getLastName() {
		if(member != null)
			return member.getLastName();
		else
			return "";
	}
	
	public Club getClub() {
		if(member != null)
			return member.getClub();
		else
			return new Club();
	}
	
	public String getMail() {
		if(member != null)
			return member.getMail();
		else
			return "";
	}
	
	public Address getAddress() {
		if(member != null)
			return member.getAddress();
		else
			return new Address();
	}
	
	public String getPhone() {
		if(member != null)
			return member.getPhone();
		else
			return "";
	}
	
	public Date getBirthDate() {
		if(member != null)
			return member.getBirthDate();
		else
			return null;
	}
	
	public String getSex() {
		if(member != null)
			return member.getSex();
		else
			return null;
	}
	
	public boolean isPsc() {
		if(member != null)
			return member.isPsc();
		else
			return false;
	}
	
	public boolean isPsc2() {
		if(member != null)
			return member.isPsc2();
		else
			return false;
	}
	
	public boolean isCoach() {
		if(member != null)
			return member.isCoach();
		else
			return false;
	}
}

package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
		System.out.println(member.getFirstName());
		System.out.println(member.getLastName());
		System.out.println(member.getMail());
		System.out.println(member.getPhone());
		System.out.println(member.getBirthDate());
		System.out.println(member.getSex());
		System.out.println(member.getAddress().getStreet());
		System.out.println(member.getAddress().getPostCode());
		System.out.println(member.getAddress().getCity());
		System.out.println(member.getAddress().getCountry());
		System.out.println("Coach:" + member.isCoach());
		System.out.println("PSC:" + member.isPsc());
		System.out.println("PSC2:" + member.isPsc2());
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
		
		memberId = request.getParameter("memberId");
		
		if(memberId != null)
			member = MySQLDatabase.getMember(memberId);
		else
			member = new Member();
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
}

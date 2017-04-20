package com.fedfeu.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fedfeu.beans.Member;

@Component
@Scope("request")
public class MemberController implements Serializable {
	private static final long serialVersionUID = -3700388372648488221L;

	private FacesContext facesContext;
	private ExternalContext externalContext;
	private DatabaseController databaseController;
	
	@Autowired
    private ApplicationContext applicationContext;

	private long memberId;
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

		databaseController.saveMember(member);
		return null;
	}

	public String updateMember() {
		return null;
	}

	@PostConstruct
	private void init() {
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		databaseController = (DatabaseController) applicationContext.getBean("databaseController");

		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		String sMemberId = request.getParameter("memberId");
		if(sMemberId != null) {
			try {
				memberId = Long.parseLong(sMemberId);
				member = databaseController.getMember(memberId);
			} catch (Exception e) {
			}
		}
		
		if(member == null) {
			memberId = -1;
			member = new Member();
		}
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}

package com.fedfeu.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fedfeu.beans.Club;
import com.fedfeu.beans.Cup;
import com.fedfeu.beans.Member;
import com.fedfeu.database.MySQLDatabase;

@ManagedBean
@SessionScoped
public class DataListController implements Serializable {
	private static final long serialVersionUID = 2799171946572973592L;

	@PostConstruct
	private void init() {
	}

	public List<Club> getClubList() {	
		return MySQLDatabase.getClubList();
	}

	public List<Cup> getCupList() {
		return MySQLDatabase.getCupList();
	}

	public List<Member> getMemberList() {
		return MySQLDatabase.getMemberList();
	}
}

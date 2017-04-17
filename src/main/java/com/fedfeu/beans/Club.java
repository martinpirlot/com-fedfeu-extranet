package com.fedfeu.beans;

import java.io.Serializable;

public class Club implements Serializable {
	private static final long serialVersionUID = 917043626784298073L;
	
	private String id;
	private String name;
	private String website;
	private Member president;
	private String mailContact;
	private Address address;

	public Club() {
		this.id = "";
		this.name = "";
		this.website = "";
		this.president = new Member();
		this.mailContact = "";
		this.address = new Address();
	}
	
	public Club(String id, String name, String website, Member president, String mailContact, Address address) {
		this.id = id;
		this.name = name;
		this.website = website;
		this.president = president;
		this.mailContact = mailContact;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Member getPresident() {
		return president;
	}

	public void setPresident(Member president) {
		this.president = president;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

package com.fedfeu.beans;

public class Club {
	private String id;
	private String name;
	private String website;
	private String president;
	private String mailContact;
	private Address address;

	public Club() {
		this.id = null;
		this.name = null;
		this.website = null;
		this.president = null;
		this.mailContact = null;
		this.address = null;
	}
	
	public Club(String id, String name, String website, String president, String mailContact, Address address) {
		super();
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

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
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

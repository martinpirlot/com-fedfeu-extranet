package com.fedfeu.beans;

import java.sql.Date;

public class Member {
	private String id;
	private String firstName;
	private String lastName;
	private Club club;
	private String mail;
	private Address address;
	private String phone;
	private Date birthDate;
	private boolean certif;
	private boolean psc;
	private boolean psc2;
	private boolean coach;
	
	public Member() {
		super();
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.club = null;
		this.mail = null;
		this.address = null;
		this.phone = null;
		this.birthDate = null;
		this.certif = false;
		this.psc = false;
		this.psc2 = false;
		this.coach = false;
	}
	
	public Member(String id, String firstName, String lastName, Club club, String mail, Address address, String phone,
			Date birthDate, boolean certif, boolean psc, boolean psc2, boolean coach) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.club = club;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.certif = certif;
		this.psc = psc;
		this.psc2 = psc2;
		this.coach = coach;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isCertif() {
		return certif;
	}

	public void setCertif(boolean certif) {
		this.certif = certif;
	}

	public boolean isPsc() {
		return psc;
	}

	public void setPsc(boolean psc) {
		this.psc = psc;
	}

	public boolean isPsc2() {
		return psc2;
	}

	public void setPsc2(boolean psc2) {
		this.psc2 = psc2;
	}

	public boolean isCoach() {
		return coach;
	}

	public void setCoach(boolean coach) {
		this.coach = coach;
	}
}

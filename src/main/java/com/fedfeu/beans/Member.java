package com.fedfeu.beans;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = -1101325964269528051L;
	
	private String id;
	private String firstName;
	private String lastName;
	private Club club;
	private String mail;
	private Address address;
	private String phone;
	private Date birthDate;
	private String sex;
	private boolean certif;
	private boolean psc;
	private boolean psc2;
	private boolean coach;
	
	public Member() {
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.club = null;
		this.mail = "";
		this.address = new Address();
		this.phone = "";
		this.birthDate = null;
		this.sex = "";
		this.certif = false;
		this.psc = false;
		this.psc2 = false;
		this.coach = false;
	}
	
	public Member(String id, String firstName, String lastName, Club club, String mail, Address address, String phone,
			Date birthDate, String sex, boolean certif, boolean psc, boolean psc2, boolean coach) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.club = club;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.sex = sex;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}

package com.fedfeu.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = -1101325964269528051L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="club_id")
	private Club club;
	private String mail;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	private String phone;
	private Date birthDate;
	@Column(nullable = false)
	private String sex;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean psc;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean psc2;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean coach;
	
	public Member() {
		this.firstName = "";
		this.lastName = "";
		this.club = null;
		this.mail = "";
		this.address = new Address();
		this.phone = "";
		this.birthDate = null;
		this.sex = "M";
		this.psc = false;
		this.psc2 = false;
		this.coach = false;
	}
	
	public Member(String firstName, String lastName, Club club, String mail, Address address, String phone,
			Date birthDate, String sex, boolean psc, boolean psc2, boolean coach) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.club = club;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.sex = sex;
		this.psc = psc;
		this.psc2 = psc2;
		this.coach = coach;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

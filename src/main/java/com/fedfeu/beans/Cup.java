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
public class Cup implements Serializable {
	private static final long serialVersionUID = 4137193302406822645L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Date startDate;
	private Date endDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "club_id")
	private Club club;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean highJump;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean tripleJump;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean freestyleStreet;

	public Cup() {
		this.name = "";
		this.startDate = null;
		this.endDate = null;
		this.address = new Address();
		this.club = new Club();
		this.highJump = false;
		this.tripleJump = false;
		this.freestyleStreet = false;
	}

	public Cup(String name, Date startDate, Date endDate, Address address, Club club, boolean highJump,
			boolean tripleJump, boolean freestyleStreet) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.club = club;
		this.highJump = highJump;
		this.tripleJump = tripleJump;
		this.freestyleStreet = freestyleStreet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public boolean isHighJump() {
		return highJump;
	}

	public void setHighJump(boolean highJump) {
		this.highJump = highJump;
	}

	public boolean isTripleJump() {
		return tripleJump;
	}

	public void setTripleJump(boolean tripleJump) {
		this.tripleJump = tripleJump;
	}

	public boolean isFreestyleStreet() {
		return freestyleStreet;
	}

	public void setFreestyleStreet(boolean freestyleStreet) {
		this.freestyleStreet = freestyleStreet;
	}

}

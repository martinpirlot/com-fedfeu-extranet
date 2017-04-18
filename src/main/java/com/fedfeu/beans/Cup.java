package com.fedfeu.beans;

import java.io.Serializable;
import java.util.Date;

public class Cup implements Serializable {
	private static final long serialVersionUID = 4137193302406822645L;
	
	private String id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Address address;
	private Club club;
	private boolean highJump;
	private boolean tripleJump;
	private boolean freestyleStreet;
	
	public Cup() {
		this.id = "";
		this.name = "";
		this.startDate = null;
		this.endDate = null;
		this.address = new Address();
		this.club = new Club();
		this.highJump = false;
		this.tripleJump = false;
		this.freestyleStreet = false;
	}
	
	public Cup(String id, String name, Date startDate, Date endDate, Address address, Club club, boolean highJump, boolean tripleJump, boolean freestyleStreet) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.club = club;
		this.highJump = highJump;
		this.tripleJump = tripleJump;
		this.freestyleStreet = freestyleStreet;
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

package com.fedfeu.beans;

import java.sql.Date;
import java.util.List;

public class Cup {
	private String id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Address address;
	private String club;
	private List<String> type;
	
	public Cup() {
		this.id = null;
		this.name = null;
		this.startDate = null;
		this.endDate = null;
		this.address = null;
		this.club = null;
		this.type = null;
	}
	
	public Cup(String id, String name, Date startDate, Date endDate, Address address, String club, List<String> type) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.club = club;
		this.type = type;
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

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}
}

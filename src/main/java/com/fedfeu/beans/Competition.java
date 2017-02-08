package com.fedfeu.beans;

import java.sql.Date;
import java.util.List;

public class Competition {
	private String id;
	private String name;
	private Date date;
	private Address address;
	private List<String> type;
	
	public Competition(String id, String name, Date date, Address address, List<String> type) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.address = address;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}
}

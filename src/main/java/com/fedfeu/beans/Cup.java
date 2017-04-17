package com.fedfeu.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Cup implements Serializable {
	private static final long serialVersionUID = 4137193302406822645L;
	
	private String id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Address address;
	private Club club;
	private List<String> typeList;
	
	public Cup() {
		this.id = "";
		this.name = "";
		this.startDate = null;
		this.endDate = null;
		this.address = new Address();
		this.club = new Club();
		this.typeList = new ArrayList<String>();
	}
	
	public Cup(String id, String name, Date startDate, Date endDate, Address address, Club club, List<String> typeList) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.club = club;
		this.typeList = typeList;
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

	public List<String> getTypeList() {
		return typeList;
	}
	
	public String getTypeListString() {
		StringBuilder sb = new StringBuilder();
		List<String> typeList = getTypeList();
		for(String type : typeList) {
			sb.append(type + ", ");
		}
		
		if(!typeList.isEmpty())
			sb.setLength(sb.length() - 2);
		
		return sb.toString();
	}

	public void setType(List<String> typeList) {
		this.typeList = typeList;
	}
}

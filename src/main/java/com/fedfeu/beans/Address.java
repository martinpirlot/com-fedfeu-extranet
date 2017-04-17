package com.fedfeu.beans;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 5452721881117379577L;
	
	private String street;
	private String postalCode;
	private String city;
	private String country;
	
	public Address() {
		this.street = "";
		this.postalCode = "";
		this.city = "";
		this.country = "";
	}
	
	public Address(String street, String postalCode, String city, String country) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return getStreet() + "," + getPostalCode() + " " + getCity();
	}
}

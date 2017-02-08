package com.fedfeu.beans;

public class Address {
	private String street;
	private int number;
	private int postalCode;
	private String city;
	private String country;
	
	public Address(String street, int number, int postalCode, String city, String country) {
		super();
		this.street = street;
		this.number = number;
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
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
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
}

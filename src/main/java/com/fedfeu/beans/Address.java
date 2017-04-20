package com.fedfeu.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 5452721881117379577L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String street;
	private String postCode;
	private String city;
	private String country;
	
	public Address() {
		this.street = "";
		this.postCode = "";
		this.city = "";
		this.country = "";
	}
	
	public Address(String street, String postCode, String city, String country) {
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
		return getStreet() + "," + getPostCode() + " " + getCity();
	}
}

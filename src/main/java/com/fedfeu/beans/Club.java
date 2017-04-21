package com.fedfeu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Club implements Serializable {
	private static final long serialVersionUID = 917043626784298073L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String website;
	@OneToOne
	@JoinColumn(name="member_id")
	private Member president;
	private String mailContact;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	@OneToMany(mappedBy = "club")
	private List<Member> members = new ArrayList<Member>();
	@OneToMany(mappedBy = "club")
	private List<Cup> cups = new ArrayList<Cup>();

	public Club() {
		this.name = "";
		this.website = "";
		this.mailContact = "";
		this.address = new Address();
	}
	
	public Club(String name, String website, Member president, String mailContact, Address address) {
		this.name = name;
		this.website = website;
		this.president = president;
		this.mailContact = mailContact;
		this.address = address;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Member getPresident() {
		return president;
	}

	public void setPresident(Member president) {
		this.president = president;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
	public List<Cup> getCups() {
		return cups;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        Club that = (Club) obj;
        return id.equals(that.id);
    }
	
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}

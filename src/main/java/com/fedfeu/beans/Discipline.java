package com.fedfeu.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discipline implements Serializable {
	private static final long serialVersionUID = -2801227867149936555L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String typeScore;
	
	public Discipline(String name, String typeScore) {
		this.name = name;
		this.typeScore = typeScore;
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

	public String getTypeScore() {
		return typeScore;
	}

	public void setTypeScore(String typeScore) {
		this.typeScore = typeScore;
	}
}

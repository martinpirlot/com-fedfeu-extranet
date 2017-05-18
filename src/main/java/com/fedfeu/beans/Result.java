package com.fedfeu.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result implements Serializable {
	private static final long serialVersionUID = 559235598170454901L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(optional = false)
	private Discipline discipline;
	@ManyToOne(optional = false)
	private Member member;
	@ManyToOne(optional = false)
	private Cup cup;
	private int score;
	
	public Result(Member member, Discipline discipline, Cup cup, int score) {
		this.member = member;
		this.discipline = discipline;
		this.cup = cup;
		this.score = score;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Discipline getDiscipline() {
		return discipline;
	}
	
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Cup getCup() {
		return cup;
	}
	
	public void setCup(Cup cup) {
		this.cup = cup;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}

package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringMentee")
public class Mentee {
	@Id
	@Column(name = "ClassId",nullable = false )
	private int classId;
	@Column(name = "MenteeEmail")
	private String menteeEmail;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getMenteeEmail() {
		return menteeEmail;
	}
	public void setMenteeEmail(String menteeEmail) {
		this.menteeEmail = menteeEmail;
	}
	
	
}

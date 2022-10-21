package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringClassResources")
public class ClassResources {
	@Id
	@Column(name = "ClassId",nullable = false )
	private int classId;
	@Column(name = "Link")
	private String link;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}

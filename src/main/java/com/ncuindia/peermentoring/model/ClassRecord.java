package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringClassRecord")
public class ClassRecord {
	@Id
	@Column(name = "ClassId",nullable = false )
	private String classId;
	@Column(name = "ClassLink", length = 45 )
	private String classLink;
	@Column(name = "RoomNo", length = 45 )
	private String roomNo;
	@Column(name = "ClassStatus", length = 45 )
	private String classStatus;
	

	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassLink() {
		return classLink;
	}
	public void setClassLink(String classLink) {
		this.classLink = classLink;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getClassStatus() {
		return classStatus;
	}
	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}
	
	
	
	
}

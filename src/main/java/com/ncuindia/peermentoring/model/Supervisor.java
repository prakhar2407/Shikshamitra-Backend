package com.ncuindia.peermentoring.model;

import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PeerMentoringSupervisor")
public class Supervisor {
	@Id
	@Column(name = "ClassId", nullable = false)
	private int classId;
	@Column(name = "ClassLink")
	private String classLink;
	@Column(name = "RoomNo")
	private String roomNo;
	@Column(name = "ClassStatus")
	private String classStatus;

	// @OneToOne(mappedBy = "Supervisor")
	// private ClassSchedule classscheduler;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
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

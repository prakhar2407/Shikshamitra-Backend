package com.ncuindia.peermentoring.model;

import javax.persistence.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PeerMentoringClassSchedule")
public class ClassSchedule {

	@Id
	@Column(name = "ClassId", nullable = false, unique = true)
	private int classId;
	@Column(name = "PeerTutor", length = 45)
	private String peerTutor;
	@Column(name = "SchoolName", length = 45)
	private String schoolName;
	@Column(name = "TopicName")
	private int topicName;
	@Column(name = "TopicContext", length = 45)
	private String topicContext;
	@Column(name = "DateTime")
	private Date dateTime;
	@Column(name = "Duration")
	private int duration;

	// // mapping with supervisor
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "SupClassId", referencedColumnName = "id")
	// private Supervisor supervisor;

	// // mapping with feedback
	// @OneToMany(mappedBy = "feedback")
	// private List<ClassFeedback> feedbacks;

	// // mapping usertable
	// // ?????refernced peerTutuor
	// @ManyToOne
	// @JoinColumn(name = "usertable_id", nullable = false)
	// private UserTable usertable;

	public ClassSchedule() {
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getPeerTutor() {
		return peerTutor;
	}

	public void setPeerTutor(String peerTutor) {
		this.peerTutor = peerTutor;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getTopicName() {
		return topicName;
	}

	public void setTopicName(int topicName) {
		this.topicName = topicName;
	}

	public String getTopicContext() {
		return topicContext;
	}

	public void setTopicContext(String topicContext) {
		this.topicContext = topicContext;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}

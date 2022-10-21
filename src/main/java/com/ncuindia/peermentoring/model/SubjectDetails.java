package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringSubjectDetails")
public class SubjectDetails {
	@Id
	@Column(name = "UserId",nullable = false )
	private String UserId;
	@Column(name = "SubjectName", length = 45 )
	private String subjectName;
	@Column(name = "TopicName", length = 45 )
	private String topicName;
	
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
}

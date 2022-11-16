package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringClassFeedback")
public class ClassFeedback {
	@Id
	@Column(name = "ClassId",nullable = false )
	private String classId;
	@Column(name = "MenteeId", length = 45 )
	private String menteeId;
	@Column(name = "Rating")
	private int rating;
	@Column(name = "FeedbackText")
	private int feedbackText;


	//mapping classschedule
	// @ManyToOne
    // @JoinColumn(name="ClassScheduleId", nullable=false)
    // private ClassSchedule classSchedule;

    public ClassFeedback() {}



    //getter and setter
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getMenteeId() {
		return menteeId;
	}

	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(int feedbackText) {
		this.feedbackText = feedbackText;
	}





}

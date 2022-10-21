package com.ncuindia.peermentoring.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="PeerMentoringUserDetails")
public class UserDetails {
	@Id
	@Column(name = "EmailId")
	private String emailId;
	@Column(name = "Name",length = 45)
	private String name;
	@Column(name = "ProfilePic",length = 45)
	private String profilePic;
	@Column(name = "Branch",length = 45)
	private String branch;
	@Column(name = "Course",length = 45)
	private String course;
	@Column(name = "Year",length = 45)
	private String year;
	@Column(name = "DOB",length = 45)
	private Date dob;
	@Column(name = "Phone",length = 45)
	private String phone;
	@Column(name = "CGPA")
	private Double cgpa;
	@Column(name = "IsVerified")
	private boolean isVerified;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
	
	

}

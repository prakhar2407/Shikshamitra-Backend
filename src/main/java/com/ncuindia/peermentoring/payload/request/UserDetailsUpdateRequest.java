package com.ncuindia.peermentoring.payload.request;

import java.util.Date;

public class UserDetailsUpdateRequest {
    String branch;
    Double cgpa;
    String course;
    Date dob;
    Boolean isVerified;
    String name;
    String phoneNumber;
    String profile_pic;
    String curr_year;

    public UserDetailsUpdateRequest(String branch, Double cgpa, String course, Date dob, Boolean isVerified, String name,
            String phoneNumber, String profile_pic, String curr_year) {
        this.branch = branch;
        this.cgpa = cgpa;
        this.course = course;
        this.dob = dob;
        this.isVerified = isVerified;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.profile_pic = profile_pic;
        this.curr_year = curr_year;
    }

    public UserDetailsUpdateRequest() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getCurr_year() {
        return curr_year;
    }

    public void setCurr_year(String curr_year) {
        this.curr_year = curr_year;
    }

}

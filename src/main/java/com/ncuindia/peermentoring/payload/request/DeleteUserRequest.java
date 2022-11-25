package com.ncuindia.peermentoring.payload.request;

public class DeleteUserRequest {
    String emailId;

    public DeleteUserRequest(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

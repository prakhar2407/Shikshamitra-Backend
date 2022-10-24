package com.ncuindia.peermentoring.payload.response;

public class UserInfoResponse {
    private String email;
    private String role;

    public UserInfoResponse(String email, String role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return role;
    }
}
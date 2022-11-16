package com.ncuindia.peermentoring.payload.response;

public class JwtResponse {
    private String jwtToken;
    private String emailId;
    private String role;
    private String type = "Bearer";
    private String refreshToken;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, String emailId, String role, String refreshToken) {
        this.jwtToken = jwtToken;
        this.emailId = emailId;
        this.role = role;
        this.refreshToken = refreshToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}

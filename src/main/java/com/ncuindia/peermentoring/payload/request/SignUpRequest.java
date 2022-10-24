package com.ncuindia.peermentoring.payload.request;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(@NotBlank @Size(max = 50) @Email String email, @NotBlank String role,
            @NotBlank @Size(min = 6, max = 40) String password) {
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

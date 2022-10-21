package com.ncuindia.peermentoring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Contains Credential Info Only and Role.

@Entity
@Table(name = "PeerMentoringUserTable")
public class UserTable {
	@Id
	@Column(name = "EmailId", nullable = false, unique = true)
	private String emailId;
	@Column(name = "Password", nullable = false, length = 45)
	private String password;
	@Column(name = "Role", nullable = false, unique = true, length = 10)
	private String role;
	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "UserTable")
	// private UserDetails userDetails;


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

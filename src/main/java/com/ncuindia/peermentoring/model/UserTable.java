package com.ncuindia.peermentoring.model;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Contains Credential Info Only and Role.

@Entity
@Table(name = "PeerMentoringUserTable")
public class UserTable implements UserDetails {
	@Id
	@Column(name = "EmailId", nullable = false, unique = true)
	private String emailId;
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "Role", nullable = false, unique = true, length = 10)
	private String role;
	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "UserTable")
	// private UserDetails userDetails;


	public UserTable() {
	}

	public UserTable(String emailId, String password, String role) {
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<>();
		authorities.add(new Authority(role));
		return authorities;
	}

	@Override
	public String getUsername() {
		return emailId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

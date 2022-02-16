package com.junkit.trade.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="f_name")
	private String firstName;
	
	@Column(name="l_name")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="username")
	private String username;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities = new HashSet<>();

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUerId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}

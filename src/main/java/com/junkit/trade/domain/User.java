package com.junkit.trade.domain;

import java.util.ArrayList;
import java.util.List;

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
	
	@Column(name="email")
	private String email;

	@JoinColumn(name = "item_id")
	@OneToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL)

	private List<Item> items = new ArrayList<>();

	@JoinColumn(name="message_id")
	@OneToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Message> messages = new ArrayList<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
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

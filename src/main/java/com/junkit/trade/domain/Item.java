package com.junkit.trade.domain;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="itm_descrpt")
	private String description;
	
	@Column(name="item_price")
	private Double itemPrice;
	
	@Column(name="post_date")
	private LocalDate postDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}

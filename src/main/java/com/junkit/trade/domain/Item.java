package com.junkit.trade.domain;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name = "photo", nullable = true)
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="item_price")
	private double itemPrice;
	
	@Column(name="post_date")
	private LocalDate postDate;

	@Column(name="isAvailable")
	private Boolean isAvailable;



	@ManyToOne
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

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean getAvailable() {
		return isAvailable;
	}

	public void setAvailable(Boolean available) {
		isAvailable = available;
	}


}

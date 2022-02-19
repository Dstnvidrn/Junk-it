package com.junkit.trade.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="Message")
public class Message {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="message_id")
	private Long messageId;
	
	@Column(name = "message_text")
	private String messageText;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;

	@ManyToOne
	private User sender;

	@ManyToOne
	private User receiver;

	@Column(name = "timeSent")
	@DateTimeFormat(pattern = "MM-dd-yyyy hh:mm")
	private LocalDateTime timeSent;

	public LocalDateTime getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(LocalDateTime timeSent) {
		this.timeSent = timeSent;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
}

package com.junkit.trade.domain;

import javax.persistence.*;
@Entity
@Table(name="CreditCard")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="card_id")
	private Long cardId;
}

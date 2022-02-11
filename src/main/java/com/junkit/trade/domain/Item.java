package com.junkit.trade.domain;

import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;
	
	

}

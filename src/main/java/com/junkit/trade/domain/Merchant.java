package com.junkit.trade.domain;

import javax.persistence.*;
@Entity
@Table(name="Merchant")
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="merchant_id")
	private Long merchantId;
	
	@Column(name="f_name")
	private String firstNname;
	
	@Column(name="l_name")
	private String lastNname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="balance")
	private Integer balance;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	@JoinColumn(name="cart_id")
	private String cart;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	@JoinColumn(name="address_id")
	private String address;
	
	
	

}

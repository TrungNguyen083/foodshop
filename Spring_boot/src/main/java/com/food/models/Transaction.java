package com.food.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long id;
	@Column(name = "transaction_date")
	private Date transactionDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "pay_method")
	private String payMethod;
	@Column(name = "pay_number")
	private String payNumber;
	@Column(name = "tns_code")
	private String tnsCode;
	@Column(name = "total")
	private double total;
	@Column(name = "discount")
	private double subtotal;
}

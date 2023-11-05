package com.food.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Withdraw {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "withdraw_id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "amount")
	private double amount;
	@Column(name = "create_date")
    private Date createDate;
	@Column(name = "update_date")
    private Date updateDate;
	@Column(name = "status")
    private String status;
}

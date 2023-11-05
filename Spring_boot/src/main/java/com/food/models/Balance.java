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
public class Balance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "balance_id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "amount")
	private double amount;
	@Column(name = "create_date")
    private Date createDate;
	@Column(name = "update_date")
    private Date updateDate;
	@Column(name = "status")
    private String status;
}

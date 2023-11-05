package com.food.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	@Column(name = "food_name")
	private String foodName;
	@Column(name = "food_type")
	private String foodType;
	@Column(name = "food_description")
	private String foodDescription;
	@Column(name = "food_price")
	private double foodPrice;
	@Column(name = "food_discount")
	private int foodDiscount;
	@Column(name = "food_discount_price")
	private double foodDiscountPrice;
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Provider provider;
	@Column(name = "action")
	private boolean action;
}

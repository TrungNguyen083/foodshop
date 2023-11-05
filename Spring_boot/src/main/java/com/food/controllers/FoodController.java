package com.food.controllers;

import java.util.List;

import com.food.service.FoodService;
import com.food.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodController {
   @Autowired
   FoodService foodService;
	
	@PostMapping(value="/addfood")
	public void saveFoods(@RequestBody Food f) {
		foodService.createFood(f);
	}

	@GetMapping("/food")
	public List<Food> allfoods() {
		return foodService.getAllFoods();
	}
	
	@PostMapping(value="/deletefood")
	public void deleteFoods(@RequestBody Food f) {
		foodService.deleteFoodById(f.getId());
	}
	
	@PostMapping(value="/updatefood")
	public Food updateFoods(@RequestBody Food f) {
		return foodService.updateFood(f);
	}
	
	@PostMapping(value="/confirmfood")
	public Food confirmFoods(@RequestBody Food f) {
		return foodService.confirmFood(f);
	}
	
	@GetMapping(value="/foods/{foodId}")
	public Food getFoodById(@PathVariable("foodId")Long foodId) {
		return foodService.getFoodById(foodId);
	}
}

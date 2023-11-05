package com.food.controllers;

import java.util.List;

import com.food.models.OrdersFood;
import com.food.service.OrdersFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrdersFoodController {
	@Autowired
	OrdersFoodService ordersFoodService;

	
	
	@PostMapping(value="/myorderfood")
	public OrdersFood addOrder(@RequestBody OrdersFood of) {
		return ordersFoodService.createOrderFood(of);
	}
	
	@PostMapping(value="/updatemyorderfood")
	public OrdersFood updateOrderFood(@RequestBody OrdersFood of) {
		return ordersFoodService.updateOrderStep(of);
	}
	
	@GetMapping("/orderfoods/{orderId}")
	public List<OrdersFood> getMyOrderFoodByUsername(@PathVariable("orderId")Long orderId) {
		return ordersFoodService.getOrderFoodByOderId(orderId);
	}
	
	@GetMapping("/getmyorderfoods/{shopId}")
	public List<OrdersFood> getMyOrderByShopId(@PathVariable("shopId")Long shopId) {
		return ordersFoodService.getOrderFoodByShopId(shopId);
		
	}
	
	@GetMapping("/getallorfood")
	public List<OrdersFood> getAllFood() {
		return ordersFoodService.getAllOrderFoods();
	}
	
	@GetMapping("/ordersfoodbyid/{orderFoodId}")
	public OrdersFood getOrderFoodByOrderFoodId(@PathVariable("orderFoodId")Long orderFoodId) {
		return ordersFoodService.getOrderFoodById(orderFoodId);
	}
}

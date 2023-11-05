package com.food.controllers;

import java.util.List;

import com.food.models.Orders;
import com.food.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@PostMapping(value="/addorder")
	public Orders addOrder(@RequestBody Orders or) {
		return ordersService.createOrder(or);
	}

	
	@GetMapping("/order/{username}")
	public List<Orders> getOrderByUsername(@PathVariable("username")String username) throws Exception {
		return ordersService.getOderByUserName(username);
		
	}
	

	@GetMapping("/orders/{orderId}")
	public Orders getOrderByOrderId(@PathVariable("orderId")Long orderId) {
		return ordersService.getOrderById(orderId);
		
	}

	@GetMapping("/allorders")
	public List<Orders> listAllOrders() {
		return ordersService.getAllOrders();
	}
}

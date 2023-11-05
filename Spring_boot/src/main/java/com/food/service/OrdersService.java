package com.food.service;

import java.util.List;

import com.food.models.Orders;
import com.food.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	OrdersRepository ordersRepository;

	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public Orders getOrderById(Long orderId) {
		return ordersRepository.findById(orderId).orElseThrow(
				() -> new RuntimeException("Orders not found with id: " + orderId)
		);
	}

	public Orders createOrder(Orders orders) {
		return ordersRepository.save(orders);
	}

	public List<Orders> getOderByUserName(String userName) throws Exception {
		try {
			return ordersRepository.findByUserName(userName);
		} catch (Exception e) {
			throw new Exception("Orders not found with userName: " + userName);
		}
	}
}

package com.food.service;

import java.util.List;

import com.food.models.OrdersFood;
import com.food.repositories.OrdersFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersFoodService {
	@Autowired
	OrdersFoodRepository ordersFoodRepository;

	public List<OrdersFood> getAllOrderFoods() {
		return ordersFoodRepository.findAll();
	}

	public OrdersFood createOrderFood(OrdersFood ordersFood) {
		return ordersFoodRepository.save(ordersFood);
	}

	public OrdersFood getOrderFoodById(Long orderFoodId) {
		return ordersFoodRepository.findById(orderFoodId).orElseThrow(
				() -> new RuntimeException("Orders Food not found with id: " + orderFoodId)
		);
	}

	public List<OrdersFood> getOrderFoodByOderId(Long orderId) {
		try {
			return ordersFoodRepository.findByOrderId(orderId);
		} catch (Exception e) {
			throw new RuntimeException("Orders Food not found with orderId: " + orderId);
		}
	}

	public List<OrdersFood> getOrderFoodByShopId(Long shopId) {
		try {
			return ordersFoodRepository.findByShopId(shopId);
		} catch (Exception e) {
			throw new RuntimeException("Orders Food not found with shopId: " + shopId);
		}
	}

	public OrdersFood updateOrderStep(OrdersFood ordersFood) {
		OrdersFood myOrdersFood = getOrderFoodById(ordersFood.getId());
		myOrdersFood.setOrderStep(ordersFood.getOrderStep());
		return ordersFoodRepository.save(myOrdersFood);
	}
}

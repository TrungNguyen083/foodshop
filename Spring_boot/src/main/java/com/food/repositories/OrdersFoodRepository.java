package com.food.repositories;

import com.food.models.OrdersFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersFoodRepository extends JpaRepository<OrdersFood, Long> {
    @Query("SELECT of FROM OrdersFood of WHERE of.orders.id = ?1")
    List<OrdersFood> findByOrderId(Long userId);

    @Query("SELECT of FROM OrdersFood of WHERE of.provider.id = ?1")
    List<OrdersFood> findByShopId(Long shopId);
}

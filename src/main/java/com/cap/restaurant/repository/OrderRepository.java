package com.cap.restaurant.repository;

import com.cap.restaurant.model.Menu;
import com.cap.restaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders_rv WHERE id = ?", nativeQuery = true)
    Order findOrderID(Integer dishID);
}

package com.cap.restaurant.service;

import com.cap.restaurant.exception.order.OrderFieldNotAddedException;
import com.cap.restaurant.exception.order.OrderNotFoundException;
import com.cap.restaurant.model.Menu;
import com.cap.restaurant.model.Order;
import com.cap.restaurant.model.OrderResponse;
import com.cap.restaurant.repository.MenuRepository;
import com.cap.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    public Order addOrder(Order order) throws OrderFieldNotAddedException {

        Menu currentMenu = menuRepository.findMenuByID(order.getDishID());
        System.out.println(order.getDishID() + " order id" + "    menu" + currentMenu);
        if (order.getDishID() == null || order.getQuantity() == null || order.getClientName() == null || order.getClientAddress() == null) {
            throw new OrderFieldNotAddedException("OrderService Message");
        }

        order.setAmount(currentMenu.getAmount() * order.getQuantity());

        return orderRepository.saveAndFlush(order);
    }

    public Order getOrder(Integer id) throws OrderNotFoundException {
        Order currentOrder = orderRepository.findOrderID(id);
        if( currentOrder == null) {
            throw new OrderNotFoundException("OderService Message");
        }

        return currentOrder;
    }
}

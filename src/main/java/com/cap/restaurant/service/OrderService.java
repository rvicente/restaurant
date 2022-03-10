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
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    private OrderStatus orderStatus;

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
        Order dBOrder = orderRepository.findOrderID(id);
        if( dBOrder == null) {
            throw new OrderNotFoundException("OderService Message");
        }

        return dBOrder;
    }


    public Order updateOrder(Order order) throws OrderNotFoundException {

        Order dBOrder = orderRepository.findOrderID(order.getId());
        if (dBOrder == null){
            throw new OrderNotFoundException("OrderService Message");
        }

        switch (order.getStatus()){
            case "1":
                order.setStatus(orderStatus.ORDER_CREATED.name());
                break;

            case "2":
                order.setStatus(orderStatus.PREPARING.name());
                break;

            case "3":
                order.setStatus(orderStatus.IN_TRANSIT.name());
                break;

            case "4":
                order.setStatus(orderStatus.DELIVERED.name());
                break;

            case "5":
                order.setStatus(orderStatus.CANCELED.name());
                break;
        }
        order.setAlterationDate(new Date());

        return orderRepository.saveAndFlush(order);
    }
}

package com.cap.restaurant.service;

import com.cap.restaurant.exception.order.OrderFieldNotAddedException;
import com.cap.restaurant.exception.order.OrderNotFoundException;
import com.cap.restaurant.exception.order.OrderStatusNotValidException;
import com.cap.restaurant.exception.order.OrderedMenuNotAvailableException;
import com.cap.restaurant.model.Menu;
import com.cap.restaurant.model.Order;
import com.cap.restaurant.repository.MenuRepository;
import com.cap.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    private OrderStatus orderStatus;

    public Order addOrder(Order order) throws OrderFieldNotAddedException, OrderedMenuNotAvailableException {

        Menu currentMenu = menuRepository.findMenuByID(order.getDishID());
        System.out.println(order.getDishID() + " order id" + "    menu" + currentMenu);
        if (order.getDishID() == null || order.getQuantity() == null || order.getClientName() == null || order.getClientAddress() == null) {
            throw new OrderFieldNotAddedException("OrderService Message");
        }

        currentMenu.setStock(currentMenu.getStock()- order.getQuantity());
        if (order.getQuantity() < 0 || currentMenu.getStock() < 0) {
            throw new OrderedMenuNotAvailableException("OrderService Message");
        }

        currentMenu.setStock(currentMenu.getStock());
        menuRepository.saveAndFlush(currentMenu);
        order.setTransactionID(UUID.randomUUID().toString());
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


    public Order updateOrder(Order order) throws OrderNotFoundException, OrderStatusNotValidException {
        Order dBOrder = orderRepository.findOrderID(order.getId());

        if (dBOrder == null) {
            throw new OrderNotFoundException("OrderService Message");
        }


        if(dBOrder.getStatus().equals("CANCELlED")){
            throw new OrderStatusNotValidException("OrderService Message");
        }
        switch (order.getStatus()) {
            case "1":
                dBOrder.setStatus(orderStatus.ORDER_CREATED.name());
                break;

            case "2":
                dBOrder.setStatus(orderStatus.PREPARING.name());
                break;

            case "3":
                dBOrder.setStatus(orderStatus.IN_TRANSIT.name());
                break;

            case "4":
                dBOrder.setStatus(orderStatus.DELIVERED.name());
                break;

            case "5":
                dBOrder.setStatus(orderStatus.CANCELlED.name());
                if (!dBOrder.getStatus().equals("DELIVERED")){
                    Menu currentMenu = menuRepository.findMenuByID(dBOrder.getDishID());
                    currentMenu.setStock(currentMenu.getStock() + dBOrder.getQuantity());
                    menuRepository.saveAndFlush(currentMenu);
                }
                break;
        }

        dBOrder.setAlterationDate(new Date());

        return orderRepository.saveAndFlush(dBOrder);
    }
}

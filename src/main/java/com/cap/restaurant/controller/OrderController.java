package com.cap.restaurant.controller;

import com.cap.restaurant.exception.order.OrderFieldNotAddedException;
import com.cap.restaurant.exception.order.OrderNotFoundException;
import com.cap.restaurant.exception.order.OrderedMenuNotAvailableException;
import com.cap.restaurant.model.Order;
import com.cap.restaurant.model.OrderResponse;
import com.cap.restaurant.repository.OrderRepository;
import com.cap.restaurant.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

   @PostMapping("/addOrder")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody Order order) throws OrderFieldNotAddedException {
        Order orderForAdd = orderService.addOrder(order);
        List<Order> currentList = new ArrayList<>();
        currentList.add(order);
        OrderResponse orderResponse = new OrderResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"addOrder Success", currentList );
        return  new ResponseEntity<>(orderResponse, HttpStatus.OK);
   }

    // TODO: 10/03/2022 receber um integer com id?? 
    @PostMapping("/getOrder")
    public ResponseEntity<OrderResponse> getOrder(@RequestBody Order order) throws OrderNotFoundException {
        Order orderForAdd = orderService.getOrder(order.getId());
        List<Order> currentList = new ArrayList<>();
        currentList.add(orderForAdd);
        OrderResponse orderResponse = new OrderResponse("ok",new Date().toString(),"200", UUID.randomUUID().toString(),"getOrder Success", currentList );
        return  new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }


}

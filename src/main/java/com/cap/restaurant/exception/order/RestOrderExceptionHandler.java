package com.cap.restaurant.exception.order;

import com.cap.restaurant.model.Order;
import com.cap.restaurant.model.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class RestOrderExceptionHandler {

    @ExceptionHandler(OrderFieldNotAddedException.class)
    public ResponseEntity<OrderResponse> orderFieldNotAddedException(){
        OrderResponse orderResponse = new OrderResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method createOrder error fetch: All fields are mandatory", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
    @ExceptionHandler(OrderedMenuNotAvailableException.class)
    public ResponseEntity<OrderResponse> orderedMenuNotAvailableException(){
        OrderResponse orderResponse = new OrderResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method createOrder error fetch: Ordered Menu is not available", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<OrderResponse> orderNotFoundException(){
        OrderResponse orderResponse = new OrderResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method findOrderById error fetch: Requested order not found", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
    @ExceptionHandler(OrderStatusNotValidException.class)
    public ResponseEntity<OrderResponse> orderStatusNotValidException(){
        OrderResponse orderResponse = new OrderResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method updateOrderStatus error fetch: Order update is not possible", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
}

package com.cap.restaurant.exception.menu;

import com.cap.restaurant.model.MenuResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class RestMenuExceptionHandler {

    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<MenuResponse> menuNotFoundException(){
        MenuResponse menuResponse = new MenuResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method getById error fetch: Could not find the MenuId requested", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(menuResponse);
    }

    @ExceptionHandler(MenuFieldNotAddedException.class)
    public ResponseEntity<MenuResponse> menuFieldNotAddedException(){
        MenuResponse menuResponse = new MenuResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method addMenu error fetch: All fields are mandatory", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(menuResponse);
    }


    @ExceptionHandler(UpdateMenuFieldNotAddedException.class)
    public ResponseEntity<MenuResponse> updateMenuFieldNotAddedException(){
        MenuResponse menuResponse = new MenuResponse("NOK", new Date().toString(), "500", UUID.randomUUID().toString(), "Method updateMeu error fetch: All fields are mandatory to update", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(menuResponse);
    }

}
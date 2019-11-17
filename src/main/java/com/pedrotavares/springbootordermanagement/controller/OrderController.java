package com.pedrotavares.springbootordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrotavares.springbootordermanagement.model.TheOrder;
import com.pedrotavares.springbootordermanagement.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;

    @GetMapping
    ResponseEntity<List<TheOrder>> getOrders(){
        return new ResponseEntity<List<TheOrder>>((List<TheOrder>)orderService.getOrders(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<TheOrder> saveOrder(@RequestBody TheOrder order){
        return new ResponseEntity<TheOrder>(orderService.saveOrder(order), HttpStatus.OK);
    }
}

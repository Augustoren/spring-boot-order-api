package com.augustorenan.springbootapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustorenan.springbootapi.entities.Order;
import com.augustorenan.springbootapi.services.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable("id") Long id) {
		return orderService.getOrderById(id);
	}

}

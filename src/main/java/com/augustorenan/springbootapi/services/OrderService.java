package com.augustorenan.springbootapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augustorenan.springbootapi.entities.Order;
import com.augustorenan.springbootapi.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
}

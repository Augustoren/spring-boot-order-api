package com.augustorenan.springbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.augustorenan.springbootapi.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

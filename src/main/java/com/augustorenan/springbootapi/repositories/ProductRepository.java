package com.augustorenan.springbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.augustorenan.springbootapi.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

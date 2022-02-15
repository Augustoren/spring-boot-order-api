package com.augustorenan.springbootapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augustorenan.springbootapi.entities.Product;
import com.augustorenan.springbootapi.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
}

package com.augustorenan.springbootapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustorenan.springbootapi.entities.Product;
import com.augustorenan.springbootapi.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllCategories(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

}

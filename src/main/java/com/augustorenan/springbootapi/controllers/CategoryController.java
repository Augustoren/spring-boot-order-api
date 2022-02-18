package com.augustorenan.springbootapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustorenan.springbootapi.entities.Category;
import com.augustorenan.springbootapi.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable("id") Long id) {
		return categoryService.getCategoryById(id);
	}

}

package com.augustorenan.springbootapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augustorenan.springbootapi.entities.Category;
import com.augustorenan.springbootapi.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
}

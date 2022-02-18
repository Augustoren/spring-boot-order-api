package com.augustorenan.springbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.augustorenan.springbootapi.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

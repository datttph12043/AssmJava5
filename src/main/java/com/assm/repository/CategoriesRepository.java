package com.assm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assm.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
	
}

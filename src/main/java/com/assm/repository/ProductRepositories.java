package com.assm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assm.entity.Product;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Integer> {
	@Query("SELECT entity FROM Product entity WHERE id = :id")
	public Product finById(@Param("id") Integer id);
	
	@Query("SELECT entity FROM Product entity WHERE entity.categorie.id = :id")
	public List<Product> finBycategories(@Param("id") Integer id);

}

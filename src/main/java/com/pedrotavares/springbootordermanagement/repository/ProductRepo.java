package com.pedrotavares.springbootordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrotavares.springbootordermanagement.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

package com.pedrotavares.springbootordermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrotavares.springbootordermanagement.model.Product;
import com.pedrotavares.springbootordermanagement.repository.ProductRepo;

@Service
public class ProductService {
	
    @Autowired
    ProductRepo productRepo;
	
    public List<Product> getProducts() {
    	return productRepo.findAll();
    }    
    
	public Product save(Product product) {
		return productRepo.save(product);
	}

}

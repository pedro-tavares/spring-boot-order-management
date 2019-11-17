package com.pedrotavares.springbootordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrotavares.springbootordermanagement.model.Product;
import com.pedrotavares.springbootordermanagement.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<List<Product>>((List<Product>) productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> saveOrder(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
    }
}

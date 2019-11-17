package com.pedrotavares.springbootordermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    @Column(name = "orderId")
    Long orderId;

    String productName;
    String productDescription;
    double unitPrice;
    
    public Product() {}

    public Product(String productName, String productDescription, double unitPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
        
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "productId = " + productId + ", orderId = " + orderId + 
        		", productName = " + productName + ", productDescription = " +
                productDescription + ", unitPrice = " + unitPrice;
    }
}

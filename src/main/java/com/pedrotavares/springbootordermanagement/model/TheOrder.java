package com.pedrotavares.springbootordermanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TheOrder {
	
    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    /*
    @ManyToOne(targetEntity = com.pedrotavares.springbootordermanagement.model.Product.class)
    @JoinColumn(name = "orderId")
    */
    @javax.persistence.Transient
    List<Product> products;
 
    String buyerEmail;
    Date orderDate;
    double totalAmount;
    
    public TheOrder() {}

    public Long getOrderID() {
        return orderId;
    }

    public void setOrderID(Long orderId) {
        this.orderId = orderId;
    }
   
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
    	double totalAmount = 0;
    	for (Product p : products) {
    		totalAmount += p.unitPrice;
    	}
    	this.totalAmount = totalAmount;
        this.products = products;
    }
    
    public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                "products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

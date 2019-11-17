package com.pedrotavares.springbootordermanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrotavares.springbootordermanagement.model.TheOrder;
import com.pedrotavares.springbootordermanagement.repository.OrderByDateRepo;
import com.pedrotavares.springbootordermanagement.repository.OrderRepo;

@Service
public class OrderService {
	
    @Autowired
    OrderRepo orderRepo;
    
    @Autowired
    OrderByDateRepo orderByDateRepo;
    
    public List<TheOrder> getOrders() {
    	return orderRepo.findAll();
    }

    public List<TheOrder> getOrders(Date startDate, Date endDate) {
    	return orderByDateRepo.findByDate(startDate, endDate);
    }
    
    public TheOrder saveOrder(TheOrder order){
    	order.setOrderDate(new Date());
    	return orderRepo.save(order);
    }
}

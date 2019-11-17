package com.pedrotavares.springbootordermanagement.repositoryimplementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedrotavares.springbootordermanagement.model.TheOrder;
import com.pedrotavares.springbootordermanagement.repository.OrderByDateRepo;

@Component
public class OrderByDateRepoImpl implements OrderByDateRepo {
	
	@Autowired
	private EntityManager em;

	public List<TheOrder> findByDate(Date startDate, Date endDate) {
		return em.createQuery("SELECT o FROM TheOrder o WHERE o.orderDate>:startDate AND o.orderDate<:endDate")
			.setParameter("startDate", startDate)
			.setParameter("endDate", endDate)
			.setMaxResults(10).getResultList();
	}
}

package com.pedrotavares.springbootordermanagement.repository;

import java.util.Date;
import java.util.List;

import com.pedrotavares.springbootordermanagement.model.TheOrder;

public interface OrderByDateRepo {
	List<TheOrder>findByDate(Date startDate, Date endDate);
}

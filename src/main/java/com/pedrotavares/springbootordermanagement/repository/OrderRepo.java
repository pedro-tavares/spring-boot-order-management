package com.pedrotavares.springbootordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrotavares.springbootordermanagement.model.TheOrder;

public interface OrderRepo extends JpaRepository<TheOrder, Long> {
}

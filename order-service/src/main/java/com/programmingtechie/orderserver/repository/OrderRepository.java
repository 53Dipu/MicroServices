package com.programmingtechie.orderserver.repository;


import com.programmingtechie.orderserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}

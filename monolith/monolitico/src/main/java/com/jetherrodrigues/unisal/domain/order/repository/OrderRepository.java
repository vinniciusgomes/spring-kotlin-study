package com.jetherrodrigues.unisal.domain.order.repository;

import com.jetherrodrigues.unisal.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

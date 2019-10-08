package com.jetherrodrigues.unisal.domain.order.repository;

import com.jetherrodrigues.unisal.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

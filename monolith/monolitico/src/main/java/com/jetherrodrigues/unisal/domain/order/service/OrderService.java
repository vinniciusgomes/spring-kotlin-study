package com.jetherrodrigues.unisal.domain.order.service;

import com.jetherrodrigues.unisal.domain.order.Order;
import com.jetherrodrigues.unisal.domain.order.repository.OrderItemRepository;
import com.jetherrodrigues.unisal.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order save(final Order order) {
        return repository.save(order);
    }

}

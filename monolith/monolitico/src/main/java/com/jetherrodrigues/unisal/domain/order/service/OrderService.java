package com.jetherrodrigues.unisal.domain.order.service;

import com.jetherrodrigues.unisal.domain.order.Order;
import com.jetherrodrigues.unisal.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional
    public Order save(Order order) {
        return repository.save(order);
    }

}

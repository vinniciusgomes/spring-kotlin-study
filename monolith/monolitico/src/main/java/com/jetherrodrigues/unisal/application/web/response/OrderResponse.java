package com.jetherrodrigues.unisal.application.web.response;

import com.jetherrodrigues.unisal.domain.order.Order;
import com.jetherrodrigues.unisal.domain.order.OrderItem;
import com.jetherrodrigues.unisal.domain.order.OrderStatus;
import com.jetherrodrigues.unisal.domain.store.Store;

import java.time.LocalDateTime;
import java.util.List;

public final class OrderResponse {

    private long id;
    private LocalDateTime created;
    private OrderStatus status;
    private Store store;
    private List<OrderItem> items;

    private OrderResponse(final Order order) {
        this.id = order.getId();
        this.created = order.getCreated();
        this.status = order.getStatus();
        this.store = order.getStore();
        this.items = order.getItems();
    }

    public static OrderResponse from(final Order order) {
        return new OrderResponse(order);
    }

}

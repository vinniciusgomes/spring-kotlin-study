package com.jetherrodrigues.unisal.application.web.request;

import com.jetherrodrigues.unisal.domain.order.Order;
import com.jetherrodrigues.unisal.domain.order.OrderItem;
import com.jetherrodrigues.unisal.domain.order.OrderStatus;
import com.jetherrodrigues.unisal.domain.store.Store;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public final class OrderRequest {

    @NotNull
    @NotEmpty
    private OrderStatus status;
    @NotNull
    @NotEmpty
    private Store store;
    @NotNull
    @NotEmpty
    private List<OrderItem> items;

    public static Order toOrder(final OrderRequest request) {
        return new Order(request.getStatus(), request.getStore(), request.getItems());
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Store getStore() {
        return store;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

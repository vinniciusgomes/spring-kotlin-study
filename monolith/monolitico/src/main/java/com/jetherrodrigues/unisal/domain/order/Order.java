package com.jetherrodrigues.unisal.domain.order;

import com.jetherrodrigues.unisal.domain.store.Store;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public final class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    private LocalDateTime created = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.OPENED;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order(){}

    public Order(final OrderStatus status, final Store store, final List<OrderItem> items) {
        this.status = status;
        this.store = store;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                status == order.status &&
                store.equals(order.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, store);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", status=" + status +
                ", store=" + store +
                ", items=" + items +
                '}';
    }
}

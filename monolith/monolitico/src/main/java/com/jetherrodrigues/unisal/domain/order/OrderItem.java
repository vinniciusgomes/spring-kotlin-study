package com.jetherrodrigues.unisal.domain.order;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public final class OrderItem implements Serializable {

    @Id
    @SequenceGenerator(name = "order_item_id_seq", sequenceName = "order_item_id_seq", allocationSize = 1)
    @GeneratedValue(generator="order_item_id_seq", strategy=GenerationType.SEQUENCE)
    @Column(name = "order_item_id")
    private long id;
    private String description;
    private LocalDateTime created = LocalDateTime.now();
    private int quantity;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id")
    private Order purchase;

    public OrderItem(){}

    private OrderItem(final OrderItem item, final Order order) {
        this.description = item.description;
        this.quantity = item.quantity;
        this.price = item.price;
        this.purchase = order;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order getPurchase() {
        return purchase;
    }

    public static OrderItem of(final OrderItem item, final Order order) {
        return new OrderItem(item, order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                quantity == orderItem.quantity &&
                price.equals(orderItem.price) &&
                purchase.equals(orderItem.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price, purchase);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + purchase +
                '}';
    }
}

package de.andrena.telldontaskkata.order.domain;

import java.math.BigDecimal;
import java.util.List;

public final class Order {

    private final long id;
    private final BigDecimal total;
    private final BigDecimal tax;
    private final List<OrderItem> items;
    private final OrderStatus status;

    public Order(long id, BigDecimal total, BigDecimal tax, List<OrderItem> items, OrderStatus status) {
        this.id = id;
        this.total = total;
        this.tax = tax;
        this.items = items;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }
}

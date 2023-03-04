package de.andrena.telldontaskkata.order.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.UnaryOperator;

import static java.util.Collections.emptyList;
import static java.util.function.UnaryOperator.identity;

public class OrderBuilder {

    private long id;
    private BigDecimal total;
    private BigDecimal tax;
    private List<OrderItem> items;
    public OrderStatus status;

    private OrderBuilder(long id, BigDecimal total, BigDecimal tax, List<OrderItem> items, OrderStatus status) {
        this.id = id;
        this.total = total;
        this.tax = tax;
        this.items = items;
        this.status = status;
    }

    public OrderBuilder withStatusRejected() {
        this.status = OrderStatus.REJECTED;
        return this;
    }

    private Order build() {
        return new Order(id, total, tax, items, status);
    }

    public static Order createdOrder(long id) {
        return createdOrder(id, identity());
    }

    public static Order createdOrder(long id, UnaryOperator<OrderBuilder> customizations) {
        return customizations.apply(new OrderBuilder(id, BigDecimal.ZERO, BigDecimal.ZERO, emptyList(), OrderStatus.CREATED)).build();
    }
}

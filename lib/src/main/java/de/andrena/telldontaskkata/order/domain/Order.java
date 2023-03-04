package de.andrena.telldontaskkata.order.domain;

import java.math.BigDecimal;
import java.util.List;

public record Order(long id, BigDecimal total, BigDecimal tax, List<OrderItem> items, OrderStatus status) {
}

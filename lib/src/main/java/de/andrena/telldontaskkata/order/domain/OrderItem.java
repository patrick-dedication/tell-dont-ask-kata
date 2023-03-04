package de.andrena.telldontaskkata.order.domain;

import de.andrena.telldontaskkata.product.domain.Product;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity, BigDecimal tax, BigDecimal taxedAmount) {
}

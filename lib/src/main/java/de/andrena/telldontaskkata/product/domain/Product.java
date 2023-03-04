package de.andrena.telldontaskkata.product.domain;

import java.math.BigDecimal;

public record Product(String name, BigDecimal price, Category category) {
}

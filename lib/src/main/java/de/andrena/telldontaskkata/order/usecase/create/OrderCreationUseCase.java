package de.andrena.telldontaskkata.order.usecase.create;

import de.andrena.telldontaskkata.order.io.Orders;
import de.andrena.telldontaskkata.product.io.Products;

import static java.util.Objects.requireNonNull;

public class OrderCreationUseCase {

    private final Orders orders;
    private final Products products;

    public OrderCreationUseCase(Orders orders, Products products) {
        this.orders = requireNonNull(orders);
        this.products = requireNonNull(products);
    }

    public void run(OrderItemsRequest request) {
        // OrderItem tax is Product price times the tax percentage for the Category, rounded HALF_UP to two decimal places
        // OrderItem taxedAmount is Product price plus OrderItem tax
        // Order tax is the sum of the OrderItem's taxes
        // Order total is the sum of the OrderItem's taxedAmounts
    }
}

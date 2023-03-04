package de.andrena.telldontaskkata.order.usecase.approve;

import de.andrena.telldontaskkata.order.io.Orders;

import static java.util.Objects.requireNonNull;

public class OrderApprovalUseCase {
    private final Orders orders;

    public OrderApprovalUseCase(Orders orders) {
        this.orders = requireNonNull(orders);
    }

    public void run(OrderApprovalRequest request) {
    }
}

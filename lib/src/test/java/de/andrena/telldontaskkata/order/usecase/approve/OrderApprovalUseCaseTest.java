package de.andrena.telldontaskkata.order.usecase.approve;

import de.andrena.telldontaskkata.order.domain.Order;
import de.andrena.telldontaskkata.order.domain.OrderBuilder;
import de.andrena.telldontaskkata.order.io.InMemoryOrders;
import de.andrena.telldontaskkata.order.io.UnknownOrderException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.andrena.telldontaskkata.order.domain.OrderAssert.assertThat;
import static de.andrena.telldontaskkata.order.domain.OrderBuilder.createdOrder;
import static de.andrena.telldontaskkata.order.usecase.approve.OrderApprovalRequest.orderApprovalRequestForOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderApprovalUseCaseTest {

    private final InMemoryOrders orders = new InMemoryOrders();
    private final OrderApprovalUseCase useCase = new OrderApprovalUseCase(orders);

    @Test
    @Disabled
    void withUnknownOrderThrowsUnknownOrderException() {
        var request = orderApprovalRequestForOrder(1);

        assertThrows(UnknownOrderException.class, () -> useCase.run(request));
    }

    @Test
    @Disabled
    void withRejectedOrderThrowsRejectedOrderCannotBeApprovedException() {
        Order order = createdOrder(1, OrderBuilder::withStatusRejected);
        orders.save(order);
        var request = orderApprovalRequestForOrder(order.id());

        assertThrows(RejectedOrderCannotBeApprovedException.class, () -> useCase.run(request));
    }

    @Test
    @Disabled
    void approvesOrder() {
        Order savedOrder = createdOrder(1);
        orders.save(savedOrder);
        var request = orderApprovalRequestForOrder(savedOrder.id());

        useCase.run(request);

        assertThat(orders.getOrders()).satisfiesExactly(
                order -> assertThat(order).hasId(savedOrder.id()).isApproved()
        );
    }

}

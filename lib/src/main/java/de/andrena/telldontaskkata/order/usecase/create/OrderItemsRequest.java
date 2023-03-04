package de.andrena.telldontaskkata.order.usecase.create;

import java.util.List;

import static java.util.Arrays.asList;

public record OrderItemsRequest(List<OrderItemRequest> requests) {

    public static OrderItemsRequest orderItemsRequestWith(OrderItemRequest... requests) {
        return new OrderItemsRequest(asList(requests));
    }
}

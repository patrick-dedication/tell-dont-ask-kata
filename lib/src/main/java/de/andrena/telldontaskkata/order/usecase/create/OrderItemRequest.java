package de.andrena.telldontaskkata.order.usecase.create;

public record OrderItemRequest(String productName, int quantity) {

    public static OrderItemRequest orderItemRequestSingle(String productName) {
        return OrderItemRequest.orderItemRequest(productName, 1);
    }

    public static OrderItemRequest orderItemRequest(String productName, int quantity) {
        return new OrderItemRequest(productName, quantity);
    }
}

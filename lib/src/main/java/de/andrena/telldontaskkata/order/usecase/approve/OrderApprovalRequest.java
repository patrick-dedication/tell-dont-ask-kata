package de.andrena.telldontaskkata.order.usecase.approve;

public record OrderApprovalRequest(long orderId) {

    public static OrderApprovalRequest orderApprovalRequestForOrder(long orderId) {
        return new OrderApprovalRequest(orderId);
    }
}

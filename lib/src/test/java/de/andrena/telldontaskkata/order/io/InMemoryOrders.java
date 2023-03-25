package de.andrena.telldontaskkata.order.io;

import de.andrena.telldontaskkata.order.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryOrders implements Orders {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        findById(order.getId()).ifPresent(orders::remove);
        this.orders.add(order);
    }

    @Override
    public Order getById(long orderId) {
        return findById(orderId).orElseThrow(UnknownOrderException::new);
    }

    private Optional<Order> findById(long orderId) {
        return orders.stream().filter(order -> order.getId() == orderId).findFirst();
    }

    public List<Order> getOrders() {
        return orders;
    }
}

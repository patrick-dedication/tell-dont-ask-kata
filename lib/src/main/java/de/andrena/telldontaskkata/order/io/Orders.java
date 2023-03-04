package de.andrena.telldontaskkata.order.io;

import de.andrena.telldontaskkata.order.domain.Order;

public interface Orders {
    void save(Order order);

    Order getById(long orderId);
}

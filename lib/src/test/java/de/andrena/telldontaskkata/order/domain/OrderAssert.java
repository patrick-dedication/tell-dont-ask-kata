package de.andrena.telldontaskkata.order.domain;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowingConsumer;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderAssert extends AbstractObjectAssert<OrderAssert, Order> {

    public OrderAssert(Order order) {
        super(order, OrderAssert.class);
    }

    public final OrderAssert hasId(long id) {
        isNotNull();

        var actualId = actual.getId();
        if (actualId != id) {
            failWithMessage("\nExpected id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, id, actualId);
        }

        return this;
    }

    public final OrderAssert hasTax(String tax) {
        return hasTax(new BigDecimal(tax));
    }

    public final OrderAssert hasTax(BigDecimal tax) {
        isNotNull();

        var actualTax = actual.getTax();
        if (!Objects.equals(actualTax, tax)) {
            failWithMessage("\nExpected tax of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, tax, actualTax);
        }

        return this;
    }

    public final OrderAssert hasTotal(String total) {
        return hasTotal(new BigDecimal(total));
    }

    public final OrderAssert hasTotal(BigDecimal total) {
        isNotNull();

        var actualTotal = actual.getTotal();
        if (!Objects.equals(actualTotal, total)) {
            failWithMessage("\nExpected total of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, total, actualTotal);
        }

        return this;
    }

    @SafeVarargs
    public final OrderAssert hasItemsSatisfyingExactly(ThrowingConsumer<OrderItem>... itemRequirements) {
        isNotNull();

        Assertions.assertThat(actual.getItems()).satisfiesExactly(itemRequirements);

        return this;
    }

    public final OrderAssert isApproved() {
        isNotNull();

        var actualStatus = actual.getStatus();
        if (!Objects.equals(actualStatus, OrderStatus.APPROVED)) {
            failWithMessage("\nExpected status of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, OrderStatus.APPROVED, actualStatus);
        }

        return this;
    }

    public static OrderAssert assertThat(Order order) {
        return new OrderAssert(order);
    }
}

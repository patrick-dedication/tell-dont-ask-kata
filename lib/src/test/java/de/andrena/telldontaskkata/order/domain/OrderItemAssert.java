package de.andrena.telldontaskkata.order.domain;

import de.andrena.telldontaskkata.product.domain.Product;
import org.assertj.core.api.AbstractObjectAssert;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItemAssert extends AbstractObjectAssert<OrderItemAssert, OrderItem> {

    public OrderItemAssert(OrderItem item) {
        super(item, OrderItemAssert.class);
    }

    public final OrderItemAssert hasProduct(Product product) {
        isNotNull();

        var actualProduct = actual.product();
        if (!Objects.equals(actualProduct, product)) {
            failWithMessage("\nExpected product of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, product, actualProduct);
        }

        return this;
    }

    public final OrderItemAssert hasQuantity(int quantity) {
        isNotNull();

        var actualQuantity = actual.quantity();
        if (!Objects.equals(actualQuantity, quantity)) {
            failWithMessage("\nExpected quantity of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, quantity, actualQuantity);
        }

        return this;
    }

    public final OrderItemAssert hasTax(String tax) {
        return hasTax(new BigDecimal(tax));
    }

    public final OrderItemAssert hasTax(BigDecimal tax) {
        isNotNull();

        var actualTax = actual.tax();
        if (!Objects.equals(actualTax, tax)) {
            failWithMessage("\nExpected tax of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, tax, actualTax);
        }

        return this;
    }

    public final OrderItemAssert hasTaxedAmount(String taxedAmount) {
        return hasTaxedAmount(new BigDecimal(taxedAmount));
    }

    public final OrderItemAssert hasTaxedAmount(BigDecimal taxedAmount) {
        isNotNull();

        var actualTaxedAmount = actual.taxedAmount();
        if (!Objects.equals(actualTaxedAmount, taxedAmount)) {
            failWithMessage("\nExpected taxedAmount of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>", actual, taxedAmount, actualTaxedAmount);
        }

        return this;
    }

    public static OrderItemAssert assertThat(OrderItem item) {
        return new OrderItemAssert(item);
    }
}

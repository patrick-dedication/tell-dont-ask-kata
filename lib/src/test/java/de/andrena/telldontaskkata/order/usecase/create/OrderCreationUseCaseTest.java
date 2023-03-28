package de.andrena.telldontaskkata.order.usecase.create;

import de.andrena.telldontaskkata.order.io.InMemoryOrders;
import de.andrena.telldontaskkata.product.io.InMemoryProducts;
import de.andrena.telldontaskkata.product.io.UnknownProductException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.andrena.telldontaskkata.order.domain.OrderAssert.assertThat;
import static de.andrena.telldontaskkata.order.domain.OrderItemAssert.assertThat;
import static de.andrena.telldontaskkata.order.usecase.create.OrderItemRequest.orderItemRequest;
import static de.andrena.telldontaskkata.order.usecase.create.OrderItemRequest.orderItemRequestSingle;
import static de.andrena.telldontaskkata.order.usecase.create.OrderItemsRequest.orderItemsRequestWith;
import static de.andrena.telldontaskkata.product.domain.ProductBuilder.productSalad;
import static de.andrena.telldontaskkata.product.domain.ProductBuilder.productTomato;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderCreationUseCaseTest {

    private final InMemoryOrders orders = new InMemoryOrders();
    private final InMemoryProducts products = new InMemoryProducts();
    private final OrderCreationUseCase useCase = new OrderCreationUseCase(orders, products);

    @Test
    @Disabled
    void withUnknownProductThrowsUnknownProductException() {
        var request = orderItemsRequestWith(orderItemRequestSingle("unknown product"));

        assertThrows(UnknownProductException.class, () -> useCase.run(request));
    }

    @Test
    @Disabled
    void savesOrder() {
        int saladQuantity = 2;
        var salad = products.add(productSalad(s -> s.withPrice("3.56")));
        var request = orderItemsRequestWith(orderItemRequest(salad.name(), saladQuantity));

        useCase.run(request);

        assertThat(orders.getOrders()).satisfiesExactly(
                order -> assertThat(order).hasTax("0.72").hasTotal("7.84").hasItemsSatisfyingExactly(
                        item -> assertThat(item).hasProduct(salad).hasQuantity(saladQuantity).hasTax("0.72").hasTaxedAmount("7.84")
                )
        );
    }

    @Test
    @Disabled
    void withMultipleItemsSavesOrder() {
        int saladQuantity = 2;
        var salad = products.add(productSalad(s -> s.withPrice("3.56")));
        int tomatoQuantity = 4;
        var tomato = products.add(productTomato(t -> t.withPrice("4.65")));
        var request = orderItemsRequestWith(
                orderItemRequest(salad.name(), saladQuantity),
                orderItemRequest(tomato.name(), tomatoQuantity)
        );

        useCase.run(request);

        assertThat(orders.getOrders()).satisfiesExactly(
                order -> assertThat(order).hasTax("2.60").hasTotal("28.32").hasItemsSatisfyingExactly(
                        item -> assertThat(item).hasProduct(salad).hasQuantity(saladQuantity).hasTax("0.72").hasTaxedAmount("7.84"),
                        item -> assertThat(item).hasProduct(tomato).hasQuantity(tomatoQuantity).hasTax("1.88").hasTaxedAmount("20.48")
                )
        );
    }
}

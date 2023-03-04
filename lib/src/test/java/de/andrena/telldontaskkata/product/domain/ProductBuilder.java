package de.andrena.telldontaskkata.product.domain;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

import static de.andrena.telldontaskkata.product.domain.CategoryBuilder.category;
import static de.andrena.telldontaskkata.product.domain.CategoryBuilder.categoryFood;

public class ProductBuilder {

    private String name;
    private BigDecimal price;
    private Category category;

    private ProductBuilder(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(String price) {
        return withPrice(new BigDecimal(price));
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    private Product build() {
        return new Product(name, price, category);
    }

    public static Product productSalad(UnaryOperator<ProductBuilder> customizations) {
        return product(p -> {
            ProductBuilder saladBuilder = p.withName("salad").withPrice("2.50").withCategory(categoryFood());
            return customizations.apply(saladBuilder);
        });
    }

    public static Product productTomato(UnaryOperator<ProductBuilder> customizations) {
        return product(p -> {
            ProductBuilder tomatoBuilder = p.withName("tomato").withPrice("5.50").withCategory(categoryFood());
            return customizations.apply(tomatoBuilder);
        });
    }

    public static Product product(UnaryOperator<ProductBuilder> customizations) {
        return customizations.apply(new ProductBuilder("TestProduct", new BigDecimal("1.00"), category())).build();
    }
}

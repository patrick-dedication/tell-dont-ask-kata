package de.andrena.telldontaskkata.product.domain;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

import static java.util.function.UnaryOperator.identity;

public class CategoryBuilder {

    private String name;
    private BigDecimal taxPercentage;

    private CategoryBuilder(String name, BigDecimal taxPercentage) {
        this.name = name;
        this.taxPercentage = taxPercentage;
    }

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder withTaxPercentage(String taxPercentage) {
        return withTaxPercentage(new BigDecimal(taxPercentage));
    }

    public CategoryBuilder withTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
        return this;
    }

    private Category build() {
        return new Category(name, taxPercentage);
    }

    public static Category categoryFood() {
        return category(c -> c.withName("Food").withTaxPercentage("10.00"));
    }

    public static Category category() {
        return category(identity());
    }

    public static Category category(UnaryOperator<CategoryBuilder> customizations) {
        return customizations.apply(new CategoryBuilder("TestCategory", new BigDecimal("19.00"))).build();
    }
}

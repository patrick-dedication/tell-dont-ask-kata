package de.andrena.telldontaskkata.product.io;

import de.andrena.telldontaskkata.product.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProducts implements Products {

    private final List<Product> products = new ArrayList<>();

    public Product add(Product product) {
        this.products.add(product);
        return product;
    }

    @Override
    public Product getByName(String name) {
        return findByName(name).orElseThrow(UnknownProductException::new);
    }

    private Optional<Product> findByName(String name) {
        return products.stream().filter(p -> p.name().equals(name)).findFirst();
    }
}

package de.andrena.telldontaskkata.product.io;

import de.andrena.telldontaskkata.product.domain.Product;

public interface Products {
    Product getByName(String name);
}

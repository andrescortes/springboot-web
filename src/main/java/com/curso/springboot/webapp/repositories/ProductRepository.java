package com.curso.springboot.webapp.repositories;

import com.curso.springboot.webapp.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private final List<Product> database;

    public ProductRepository() {
        this.database = Arrays.asList(
                new Product(1L, "Iphone X", "Amazing phone to buy without a credit card", 100.0),
                new Product(2L, "Iphone 8", "A new generation of smartphones coming", 200.0),
                new Product(3L, "Iphone 7", "The last generation of smartphones", 300.0)
        );
    }

    public Product findById(Long id) {
        return database
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product save(Product product) {
        database.add(product);
        return product;
    }

    public void deleteById(Long id) {
        database.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> findAll() {
        return database;
    }
}

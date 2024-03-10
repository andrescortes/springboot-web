package com.curso.springboot.webapp.repositories;

import com.curso.springboot.webapp.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
//@RequestScope
//@SessionScope
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> database;

    public ProductRepositoryImpl() {
        this.database = Arrays.asList(
                new Product(1L, "Iphone X", "Amazing phone to buy without a credit card", 100.0),
                new Product(2L, "Iphone 8", "A new generation of smartphones coming", 200.0),
                new Product(3L, "Iphone 7", "The last generation of smartphones", 300.0)
        );
    }

    @Override
    public Product findById(Long id) {
        return database
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product save(Product product) {
        database.add(product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        database.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public List<Product> findAll() {
        return database;
    }
}

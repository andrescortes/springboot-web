package com.curso.springboot.webapp.repositories;

import com.curso.springboot.webapp.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryFooImpl implements ProductRepository {

    private final List<Product> products;

    public ProductRepositoryFooImpl() {
        this.products = List.of(
                new Product(1L, "Product 1", "iphone", 10.0),
                new Product(2L, "Product 2", "ipad", 20.0),
                new Product(3L, "Product 3", "macbook", 30.0)
        );
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}

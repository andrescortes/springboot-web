package com.curso.springboot.webapp.services;

import com.curso.springboot.webapp.models.Product;
import com.curso.springboot.webapp.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> {
                    double priceTax = product.getPrice() * 1.25d;
                    Product cloned = product.clone();
                    cloned.setPrice(Math.round(priceTax));
                    return cloned;
                })
                .collect(Collectors.toList());
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

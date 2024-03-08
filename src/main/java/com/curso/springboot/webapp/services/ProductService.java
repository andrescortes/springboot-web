package com.curso.springboot.webapp.services;

import com.curso.springboot.webapp.models.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);
}

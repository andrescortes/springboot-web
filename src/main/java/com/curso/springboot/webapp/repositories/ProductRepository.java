package com.curso.springboot.webapp.repositories;

import com.curso.springboot.webapp.models.Product;

import java.util.List;

public interface ProductRepository {


    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findAll();
}

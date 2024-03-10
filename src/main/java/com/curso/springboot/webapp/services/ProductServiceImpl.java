package com.curso.springboot.webapp.services;

import com.curso.springboot.webapp.models.Product;
import com.curso.springboot.webapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository
                .findAll()
                .stream()
                .map(product -> {
                    double priceTax = product.getPrice() * tax;
                    Product cloned = product.clone();
                    cloned.setPrice(Math.round(priceTax));
                    return cloned;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

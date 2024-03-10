package com.curso.springboot.webapp.repositories;

import com.curso.springboot.webapp.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    protected List<Product> products;


    public ProductRepositoryJson(Resource resource) {
        if (resource.exists()) {
            try {
                products = Arrays.asList(MAPPER.readValue(resource.getInputStream(), Product[].class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            fillProducts();
        }
    }

    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("data/product.json");
        if (resource.exists()) {
            try {
//            TypeReference<List<Product>> typeReference = new TypeReference<>() {
//            };
//            products = mapper.readValue(resource.getInputStream(), typeReference);
                products = Arrays.asList(MAPPER.readValue(resource.getInputStream(), Product[].class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            fillProducts();
        }
    }

    protected void fillProducts() {
        products = List.of(
                new Product(1L, "Product 1", "iphone", 10.0),
                new Product(2L, "Product 2", "ipad", 20.0),
                new Product(3L, "Product 3", "macbook", 30.0)
        );
    }

    @Override
    public Product findById(Long id) {
        return products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
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

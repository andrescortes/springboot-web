package com.curso.springboot.webapp.config;

import com.curso.springboot.webapp.repositories.ProductRepository;
import com.curso.springboot.webapp.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Value("classpath:data/product.json")
    private Resource resource;

    @Bean
    @Primary
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }
}

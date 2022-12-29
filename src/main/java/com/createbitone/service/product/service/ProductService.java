package com.createbitone.service.product.service;

import com.createbitone.service.product.model.Product;
import com.createbitone.service.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> products(){
        return this.productRepository.findAll();
    }

    public Mono<Product> addProduct(Product product){
        return this.productRepository.save(product);
    }
}

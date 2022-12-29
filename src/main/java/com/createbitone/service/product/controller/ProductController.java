package com.createbitone.service.product.controller;

import com.createbitone.service.product.model.Product;
import com.createbitone.service.product.model.ProductInput;
import com.createbitone.service.product.model.Skus;
import com.createbitone.service.product.repository.SkusRepository;
import com.createbitone.service.product.service.ProductService;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Controller
public class ProductController {

    private ProductService productService;
    private SkusRepository skusRepository;

    public ProductController(ProductService productService, SkusRepository skusRepository) {
        this.productService = productService;
        this.skusRepository = skusRepository;
    }

    @QueryMapping
    Flux<Product> products(){
        return this.productService.products();
    }

    @QueryMapping
    Flux<Product> findProductBySkus(@Argument Set<String> skus){
        Flux<Skus> skuss = this.skusRepository.findByNumberIn(skus);
        return null;
    }

    @SchemaMapping(typeName = "Product")
    Flux<Skus> skus(Product product){
        return this.skusRepository.findByProductId(product.getId());
    }

    @MutationMapping()
    Mono<Product> addProduct(@Argument ProductInput product){
        return this.productService.addProduct(Product.builder()
                        .id(Long.valueOf(6))
                .label(product.getLabel())
                .description(product.getDescription())
                .build());
    }

}

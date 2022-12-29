package com.createbitone.service.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInput {

    private Long id;
    private String label;
    private String description;
    private Skus skus;
}

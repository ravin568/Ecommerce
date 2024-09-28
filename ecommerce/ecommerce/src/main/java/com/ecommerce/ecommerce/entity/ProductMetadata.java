package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductMetadata {
    @Id
    private String productId;

    private String category;
    private String brand;
}

package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.ProductMetadata;
import com.ecommerce.ecommerce.repository.ProductMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMetadataService {
    @Autowired
    private ProductMetadataRepository productMetadataRepository;

    public ProductMetadata saveProductMetadata(ProductMetadata productMetadata) {
        return productMetadataRepository.save(productMetadata);
    }
}

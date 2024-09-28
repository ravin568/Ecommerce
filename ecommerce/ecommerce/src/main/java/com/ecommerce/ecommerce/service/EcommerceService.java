package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.ShopperProduct;
import com.ecommerce.ecommerce.repository.ProductMetadataRepository;
import com.ecommerce.ecommerce.repository.ShopperProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcommerceService {
    @Autowired
    private ShopperProductRepository shopperProductRepository;

    @Autowired
    private ProductMetadataRepository productMetadataRepository;

    public static final Logger logger = LoggerFactory.getLogger(EcommerceService.class);

    public List<ShopperProduct.ProductInfo> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        logger.info("fetching product for ShopperId: {}, with Category: {}, Brand: {}, limit: {}",shopperId,category,brand,limit);
        List<ShopperProduct> shopperProducts = shopperProductRepository.findByShopperId(shopperId);

        return shopperProducts.stream()
                .flatMap(shopperProduct -> shopperProduct.getShelf().stream())
                .filter(productInfo -> (category == null || productMetadataRepository.findById(Long.valueOf(productInfo.getProductId())).get().getCategory().equals(category)) &&
                        (brand == null || productMetadataRepository.findById(Long.valueOf(productInfo.getProductId())).get().getBrand().equals(brand)))
                .limit(limit)
                .collect(Collectors.toList());
    }
}

package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.ShopperProduct;
import com.ecommerce.ecommerce.repository.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperProductService {
    @Autowired
    private ShopperProductRepository shopperProductRepository;

    public ShopperProduct saveShopperProduct(ShopperProduct shopperProduct) {
        return shopperProductRepository.save(shopperProduct);
    }

    public List<ShopperProduct> getShopperProducts(String shopperId) {
        return shopperProductRepository.findByShopperId(shopperId);
    }
}

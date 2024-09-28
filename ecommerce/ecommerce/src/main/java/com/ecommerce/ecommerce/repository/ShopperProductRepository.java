package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopperProductRepository extends JpaRepository<ShopperProduct,Long> {
    List<ShopperProduct> findByShopperId(String shopperId);
}

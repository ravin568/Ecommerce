package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Exception.EcommerceException;
import com.ecommerce.ecommerce.entity.ShopperProduct;
import com.ecommerce.ecommerce.service.EcommerceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {
    @Autowired
    private EcommerceService ecommerceService;

    private static final Logger logger = LoggerFactory.getLogger(EcommerceController.class);

    @GetMapping("/products")
    public ResponseEntity<List<ShopperProduct.ProductInfo>> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {
       // System.out.println("request received");
        logger.info("received request for shopperId: {}, category: {}, brand: {}, limit:{}",shopperId,category,brand,limit);

        try {
            List<ShopperProduct.ProductInfo> products = ecommerceService.getProductsByShopper(shopperId,category,brand,limit);
            //return ResponseEntity.ok(ecommerceService.getProductsByShopper(shopperId, category, brand, limit));
            logger.info("succesfully retrieve the shopper product: {}",shopperId);
            return ResponseEntity.ok(products);

        } catch (Exception e) {
            logger.info("Error retrieving for shopperId: {}",shopperId);
            throw new EcommerceException("fail to retrieve product for shopper",e);
        }
    }
}

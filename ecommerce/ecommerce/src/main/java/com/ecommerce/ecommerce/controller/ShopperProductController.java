package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Exception.InvalidDataException;
import com.ecommerce.ecommerce.entity.ProductMetadata;
import com.ecommerce.ecommerce.entity.ShopperProduct;
import com.ecommerce.ecommerce.service.ProductMetadataService;
import com.ecommerce.ecommerce.service.ShopperProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
public class ShopperProductController {

    public static final Logger logger = LoggerFactory.getLogger(ShopperProductController.class);

    @Autowired
    private ShopperProductService shopperProductService;

    @Autowired
    ProductMetadataService productMetadataService;

    @PostMapping("/shopper-product")
    public ResponseEntity<ShopperProduct> saveShopperProduct(@RequestBody ShopperProduct shopperProduct) throws Throwable {

        try{
            ShopperProduct shopperProduct1 = shopperProductService.saveShopperProduct(shopperProduct);
            logger.info("Receive request to save metaData for shopperProduct: {}",shopperProduct);
            return ResponseEntity.ok(shopperProduct1);

        } catch (Exception e) {
            throw (Throwable) ResponseEntity.status(BAD_REQUEST);
        }

        //return ResponseEntity.ok(shopperProductService.saveShopperProduct(shopperProduct));
    }

    @PostMapping("/product-metadata")
    public ResponseEntity<ProductMetadata> saveProductMetadata(@RequestBody ProductMetadata productMetadata) {
        logger.info("Receive request to save metaData for Product: {}",productMetadata);
        try{
            ProductMetadata productMetadata1 = productMetadataService.saveProductMetadata(productMetadata);
            logger.info("succefully saved productMetaData: {}",productMetadata.getProductId());
            return ResponseEntity.ok(productMetadata1);
        } catch (Exception e) {
            return (ResponseEntity<ProductMetadata>) ResponseEntity.status(BAD_REQUEST);
        }
        //return ResponseEntity.ok(productMetadataService.saveProductMetadata(productMetadata));
    }
}

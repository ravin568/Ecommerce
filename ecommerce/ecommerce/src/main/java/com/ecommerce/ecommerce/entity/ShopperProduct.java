package com.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShopperProduct {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String shopperId;

        @ElementCollection
        private List<ProductInfo> shelf = new ArrayList<>();


        @Embeddable
        @Data
        public static class ProductInfo {
            private String productId;
            private double relevancyScore;
        }

}

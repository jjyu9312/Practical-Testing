package com.kkw.cafekiosk.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int productNumber;

    private String name;

    private int price;

    private ProductSellingStatus productSellingStatus;

    private ProductType productType;

    @Builder
    public Product(int productNumber, String name, int price, ProductSellingStatus productSellingStatus, ProductType productType) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.productSellingStatus = productSellingStatus;
        this.productType = productType;
    }
}

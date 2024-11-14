package com.kkw.cafekiosk.spring.domain.product;

import com.kkw.cafekiosk.spring.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;



    @Builder
    public Product(String productNumber, String name, int price, ProductSellingStatus productSellingStatus, ProductType productType) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.sellingStatus = productSellingStatus;
        this.type = productType;
    }
}

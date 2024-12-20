package com.kkw.cafekiosk.spring.product;

import com.kkw.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.kkw.cafekiosk.spring.domain.product.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsRes {

    private Long id;

    private String productNumber;

    private String name;

    private int price;

    private ProductSellingStatus productSellingStatus;

    private ProductType productType;

    public ProductsRes(Long id, String productNumber, String name, int price,
        ProductSellingStatus productSellingStatus, ProductType productType) {
        this.id = id;
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.productSellingStatus = productSellingStatus;
        this.productType = productType;
    }
}

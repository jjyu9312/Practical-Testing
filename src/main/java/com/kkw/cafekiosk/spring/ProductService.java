package com.kkw.cafekiosk.spring;

import com.kkw.cafekiosk.spring.domain.Product;
import com.kkw.cafekiosk.spring.domain.ProductRepository;
import com.kkw.cafekiosk.spring.domain.ProductSellingStatus;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsRes> findAllByProductSellingStatusIn(List<ProductSellingStatus> productSellingStatusList) {

        List<Product> products = productRepository.findAllByProductSellingStatusIn(productSellingStatusList);

        return products.stream()
            .map(product -> new ProductsRes(product.getId(), product.getProductNumber(), product.getName(), product.getPrice(), product.getProductSellingStatus(), product.getProductType()))
            .collect(Collectors.toList());
    }
}

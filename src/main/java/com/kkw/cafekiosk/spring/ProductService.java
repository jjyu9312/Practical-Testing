package com.kkw.cafekiosk.spring;

import static com.kkw.cafekiosk.spring.domain.ProductSellingStatus.HOLD;
import static com.kkw.cafekiosk.spring.domain.ProductSellingStatus.SELLING;

import com.kkw.cafekiosk.spring.domain.Product;
import com.kkw.cafekiosk.spring.domain.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsRes> findAllByProductSellingStatusIn() {

        List<Product> products = productRepository.findAllByProductSellingStatusIn(
            List.of(SELLING, HOLD));

        return products
            .stream()
            .map(
            product -> new ProductsRes(product.getId(), product.getProductNumber(),
                product.getName(), product.getPrice(), product.getProductSellingStatus(),
                product.getProductType())
            )
            .collect(
                Collectors.toList()
            );
    }
}

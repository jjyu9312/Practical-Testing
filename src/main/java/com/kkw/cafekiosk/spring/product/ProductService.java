package com.kkw.cafekiosk.spring.product;

import static com.kkw.cafekiosk.spring.domain.product.ProductSellingStatus.HOLD;
import static com.kkw.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;

import com.kkw.cafekiosk.spring.domain.product.Product;
import com.kkw.cafekiosk.spring.domain.product.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductsRes> findAllByProductSellingStatusIn() {

        List<Product> products = productRepository.findAllBySellingStatusIn(
            List.of(SELLING, HOLD));

        return products
            .stream()
            .map(
            product -> new ProductsRes(product.getId(), product.getProductNumber(),
                product.getName(), product.getPrice(), product.getSellingStatus(),
                product.getType())
            )
            .collect(
                Collectors.toList()
            );
    }
}

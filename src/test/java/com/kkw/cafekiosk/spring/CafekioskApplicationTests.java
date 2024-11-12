package com.kkw.cafekiosk.spring;

import com.kkw.cafekiosk.spring.domain.Product;
import com.kkw.cafekiosk.spring.domain.ProductRepository;
import com.kkw.cafekiosk.spring.domain.ProductSellingStatus;
import com.kkw.cafekiosk.spring.domain.ProductType;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CafeKioskApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("주문 상태가 판매 종료가 아닌 상품 목록을 조회합니다.")
    void test() {

        // given
        Product product1 = Product.builder()
            .productNumber(1)
            .name("아메리카노")
            .price(4000)
            .productSellingStatus(ProductSellingStatus.SELLING)
            .productType(ProductType.HANDMADE)
            .build();

        Product product2 = Product.builder()
            .productNumber(2)
            .name("라떼")
            .price(4500)
            .productSellingStatus(ProductSellingStatus.HOLD)
            .productType(ProductType.HANDMADE)
            .build();

        List<Product> products = List.of(product1, product2);

        productRepository.saveAll(products);

        // when
        List<Product> findProducts = productRepository.findAllByProductSellingStatusIn(
            List.of(ProductSellingStatus.SELLING, ProductSellingStatus.HOLD));

        // then
        assertThat(findProducts.size()).isEqualTo(2);
    }

}

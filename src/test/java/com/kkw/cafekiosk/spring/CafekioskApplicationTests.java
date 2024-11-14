package com.kkw.cafekiosk.spring;

import static org.assertj.core.api.Assertions.assertThat;

import com.kkw.cafekiosk.spring.domain.product.Product;
import com.kkw.cafekiosk.spring.domain.product.ProductRepository;
import com.kkw.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.kkw.cafekiosk.spring.domain.product.ProductType;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
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
            .productNumber("001")
            .name("아메리카노")
            .price(4000)
            .productSellingStatus(ProductSellingStatus.SELLING)
            .productType(ProductType.HANDMADE)
            .build();

        Product product2 = Product.builder()
            .productNumber("002")
            .name("라떼")
            .price(4500)
            .productSellingStatus(ProductSellingStatus.HOLD)
            .productType(ProductType.HANDMADE)
            .build();

        List<Product> products = List.of(product1, product2);

        productRepository.saveAll(products);

        // when
        List<Product> findProducts = productRepository.findAllBySellingStatusIn(
            List.of(ProductSellingStatus.SELLING, ProductSellingStatus.HOLD));

        // then
        assertThat(findProducts)
            .isEqualTo(2)
            .extracting("name")
            .contains("아메리카노", "라떼")
        ;
    }
}

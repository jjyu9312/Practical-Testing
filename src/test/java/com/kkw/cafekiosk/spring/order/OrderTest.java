package com.kkw.cafekiosk.spring.order;

import com.kkw.cafekiosk.spring.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    @Test
    @DisplayName("주문을 생성합니다.")
    void test() {

        // given
        Product product1 = Product.builder().build();
        Product product2 = Product.builder().build();


        // when

        // then

    }
}

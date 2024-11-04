
package com.kkw.cafekiosk.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CafeKioskTDDTest {

    @Test
    void test() { System.out.println("test"); }

    @Test
    @DisplayName("주문 가격을 계산할 수 있습니다.")
    void calculateTotalPrice() {
        CafeKioskTDD cafeKiosk = new CafeKioskTDD();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        int totalPrice = cafeKiosk.calculateTotalPrice();

        assertThat(totalPrice).isEqualTo(8500);
    }
}

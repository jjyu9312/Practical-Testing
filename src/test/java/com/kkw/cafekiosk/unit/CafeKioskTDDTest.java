
package com.kkw.cafekiosk.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.kkw.cafekiosk.unit.order.Order;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class CafeKioskTDDTest {

    @Test
    void test() {
        System.out.println("test");
    }

    @Test
    void calculateTotalPrice() {
        CafeKioskTDD cafeKiosk = new CafeKioskTDD();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        int totalPrice = cafeKiosk.calculateTotalPriceTDD();

        assertThat(totalPrice).isEqualTo(8500);
    }
}

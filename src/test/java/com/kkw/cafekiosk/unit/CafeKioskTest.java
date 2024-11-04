package com.kkw.cafekiosk.unit;

import static org.assertj.core.api.Assertions.*;

import com.kkw.cafekiosk.unit.order.Order;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CafeKioskTest {

    @Test
    void test() {
        System.out.println("test");
    }

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
    }

    @Test
    void addSeveralBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano ame = new Americano();
        cafeKiosk.add(ame, 2);

        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(ame);
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(ame);
    }

    @Test
    void remove() {
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(americano, 1);

        cafeKiosk.remove(americano);
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(0);
    }

    @Test
    void clear() {
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);

        Latte latte = new Latte();
        assertThat(latte.getPrice()).isEqualTo(5000);

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(americano, 1);
        cafeKiosk.add(latte, 1);

        cafeKiosk.clear();
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("주문을 생성할 수 있습니다.")
    void createOrder() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        Order order = cafeKiosk.createOrder();
        assertThat(order.getBeverages()).hasSize(2);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    @DisplayName("주문 시각 내에는 주문을 생성할 수 있습니다.")
    void createOrderWithCurrentDateTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        Order order = cafeKiosk.createOrder(
            LocalDateTime.of(2023, 1, 17, 10, 0
            )
        );
        assertThat(order.getBeverages()).hasSize(2);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    @DisplayName("카페 오픈 시간 이전에는 주문을 생성할 수 없습니다.")
    void createOrderOutsideOpenTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        assertThatIllegalStateException().isThrownBy(() -> cafeKiosk.createOrder(
                LocalDateTime.of(2023, 1, 17, 9, 59)
            )
        );
    }

    @Test
    @DisplayName("카페 종료 시간 이후에는 주문을 생성할 수 없습니다.")
    void createOrderOutsideCloseTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        assertThatThrownBy(() -> cafeKiosk.createOrder(
                LocalDateTime.of(2023, 1, 17, 22, 59)
            )
        )
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.")
        ;
    }
}

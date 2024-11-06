
package com.kkw.cafekiosk.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CafeKioskTDDTest {

    @Test
    @DisplayName("테스트가 잘 동작하는지 확인합니다.")
    void test() { System.out.println("test"); }

    @Test
    @DisplayName("주문 목록에 담긴 음료의 가격을 계산할 수 있습니다.")
    void calculateTotalPrice() {
        // given
        // 테스트의 초기 상태나 전체 조건을 설정하는 단계 즉, 시스템이 특정 동작을 수행하기 전에 필요한 모든 조건이나 맥락을 설정
        CafeKioskTDD cafeKiosk = new CafeKioskTDD();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        // when
        // 테스트의 실제 동작을 수행하는 단계 즉, 시스템이 특정 동작을 수행하는 상황을 정의
        int totalPrice = cafeKiosk.calculateTotalPrice();

        // then
        // 특정 조건과 행동이 이루어지는 예상되는 결과를 정의하는 단계 즉, 시스템이 특정 동작을 수행한 결과를 검증
        assertThat(totalPrice).isEqualTo(8500);
    }
}

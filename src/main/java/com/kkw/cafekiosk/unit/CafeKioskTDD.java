package com.kkw.cafekiosk.unit;

import com.kkw.cafekiosk.unit.order.Order;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class CafeKioskTDD {

    // 전역 변수로 음료 리스트를 선언
    private final List<Beverage> beverages = new ArrayList<>();

    // 단순 add 함수
    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    public int calculateTotalPriceTDD() {
        // red : 실패할 테스트로 코드를 작성
        // int red = 0;

        // green : 테스트를 성공할 정도로 아주 작게 코드를 작성
        // int green = 8500;

        // refactoring : 실제 로직으로 리팩토링
        int totalPrice;
        totalPrice = beverages.stream()
            .mapToInt(Beverage::getPrice)
            .sum();

        return totalPrice;
    }
}
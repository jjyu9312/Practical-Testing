package com.kkw.cafekiosk.unit;

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

    public int calculateTotalPrice() {
        int result;

        // red : 실패할 테스트로 코드를 작성
        // result = 0;

        // green : 테스트를 성공할 정도로 아주 작게 코드를 작성
        // result = 8500;

        // refactoring : 실제 로직으로 리팩토링
        result = beverages.stream()
            .mapToInt(Beverage::getPrice)
            .sum();

        return result;
    }
}

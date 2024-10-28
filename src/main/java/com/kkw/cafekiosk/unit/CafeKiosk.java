package com.kkw.cafekiosk.unit;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class CafeKiosk {

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("음료의 수량은 1개 이상이어야 합니다.");
        }

        for (int i = 0; i < count; i++) {
            beverages.add(beverage);
        }
    }

    public void remove(Beverage beverage) {
        beverages.remove(beverage);
    }

    public void clear() {
        beverages.clear();
    }
}

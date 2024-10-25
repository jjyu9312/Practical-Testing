package com.kkw.cafekiosk.unit;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class CafeKiosk {

    private final List<Beverage> beverages = new ArrayList<>();

    void add(Beverage beverage) {
        beverages.add(beverage);
    }

    void remove(Beverage beverage) {
        beverages.remove(beverage);
    }

    void clear() {
        beverages.clear();
    }
}

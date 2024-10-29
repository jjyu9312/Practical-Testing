package com.kkw.cafekiosk.unit;

import com.kkw.cafekiosk.unit.order.Order;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class CafeKiosk {

    private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
    private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

    private final List<Beverage> beverages = new ArrayList<>();

    // 단순 add 함수
    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    // add 함수 오버로딩
    // 한 종류의 음료를 여러 잔 담는 기능
    public void add(Beverage beverage, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("음료의 수량은 1개 이상이어야 합니다.");
        } else if (count > 11) {
            throw new IllegalArgumentException("최대 주문 가능 음료 수량은 10개 입니다.");
        }

        for (int i = 0; i < count; i++) {
            beverages.add(beverage);
        }
    }

    public void remove(Beverage beverage) {
        beverages.remove(beverage);
    }

    // remove 함수 오버로딩
    // 한 종류의 음료를 여러 잔 빼는 기능
    public void remove(Beverage beverage, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("음료의 수량은 1개 이상이어야 합니다.");
        }

        for (int i = 0; i < count; i++) {
            beverages.remove(beverage);
        }
    }

    public void clear() {
        beverages.clear();
    }

    public int calculateTotalPrice() {
        return beverages.stream()
            .mapToInt(Beverage::getPrice)
            .sum();
    }

    public Order createOrder() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalTime currentTime = currentDateTime.toLocalTime();

        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalStateException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(currentDateTime, beverages);
    }

    // createOrder 함수 오버로딩
    // 특정 시간을 받아서 주문을 생성하는 기능
    public Order createOrder(LocalDateTime currentDateTime) {
        LocalTime currentTime = currentDateTime.toLocalTime();

        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalStateException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(currentDateTime, beverages);
    }
}

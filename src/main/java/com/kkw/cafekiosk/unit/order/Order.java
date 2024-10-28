package com.kkw.cafekiosk.unit.order;

import com.kkw.cafekiosk.unit.Beverage;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {

    private final LocalDateTime orderDateTime;

    private final List<Beverage> beverages;
}

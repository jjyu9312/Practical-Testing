package com.kkw.cafekiosk.spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSellingStatus {
    SELLING("판매중"),
    HOLD("보류"),
    STOP_SELLING("판매중지");

    private final String text;
}

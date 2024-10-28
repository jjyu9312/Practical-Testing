package com.kkw.cafekiosk.unit;

import static org.assertj.core.api.Assertions.assertThat;

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
        Americano am = new Americano();
        cafeKiosk.add(am, 2);

        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(am);
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(am);
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
}

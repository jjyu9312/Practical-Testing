package com.kkw.cafekiosk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.kkw.cafekiosk.unit.Americano;
import com.kkw.cafekiosk.unit.CafeKiosk;
import com.kkw.cafekiosk.unit.Latte;
import org.junit.jupiter.api.Test;

public class AmericanoTest {

    @Test
    void test() {
        System.out.println("test");
    }

    @Test
    void add() {
        Americano americano = new Americano();
        assertThat(americano.getName()).isEqualTo("아메리카노");

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(americano, 1);
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
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

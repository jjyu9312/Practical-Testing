package com.kkw.cafekiosk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.kkw.cafekiosk.unit.Americano;
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
    }
}

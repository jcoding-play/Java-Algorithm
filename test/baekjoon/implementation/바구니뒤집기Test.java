package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 바구니뒤집기Test {
    private 바구니뒤집기 main;

    @BeforeEach
    void setUp() {
        main = new 바구니뒤집기();
    }

    @Test
    @DisplayName("배열이 주어지고 입력된 범위를 역순으로 바꿀수 있다.")
    void reverse() {
        int[] basket = {1, 2, 3, 4, 5};
        main.reverse(basket, 1, 3);

        assertEquals(3, basket[0]);
        assertEquals(2, basket[1]);
        assertEquals(1, basket[2]);
    }

    @Test
    @DisplayName("두 개의 인덱스를 입력받아 번호를 바꿀 수 있다.")
    void change() {
        int[] basket = {1, 2, 3, 4, 5};
        main.change(basket, 1, 4);

        assertEquals(5, basket[1]);
        assertEquals(2, basket[4]);
    }
}
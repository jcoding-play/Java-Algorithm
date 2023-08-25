package baekjoon.implementation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class 세_수Test {
    private 세_수 main = new 세_수();

    @Test
    void getNumbers() {
        List<Integer> numbers = main.getNumbers("20 30 10");
        assertEquals(10, numbers.get(0));
        assertEquals(20, numbers.get(1));
        assertEquals(30, numbers.get(2));
    }
}
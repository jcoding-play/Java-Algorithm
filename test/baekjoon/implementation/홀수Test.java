package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class 홀수Test {
    private 홀수 main;

    @BeforeEach
    void setUp() {
        main = new 홀수();
    }

    @Test
    @DisplayName("주어진 숫자 중 홀수들만 찾을 수 있다.")
    void findOddNumbers() {
        List<Integer> numbers = List.of(12, 77, 38, 41, 53, 92, 85);
        List<Integer> oddNumbers = main.findOddNumbers(numbers);

        assertEquals(4, oddNumbers.size());
    }

    @Test
    void calculateSumOf() {
        List<Integer> oddNumbers = List.of(77, 41, 53, 85);
        Integer sum = main.calculateSumOf(oddNumbers);

        assertEquals(256, sum);
    }

    @Test
    void findMinimumNumberOf() {
        List<Integer> oddNumbers = List.of(77, 41, 53, 85);
        Integer min = main.findMinimumNumberOf(oddNumbers);

        assertEquals(41, min);
    }
}
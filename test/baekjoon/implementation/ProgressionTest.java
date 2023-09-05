package baekjoon.implementation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgressionTest {

    @Test
    @DisplayName("수열을 만들 수 있다.")
    void initNumbers() {
        Progression progression = Progression.of(3, 7);
        List<Integer> numbers = progression.initNumbers();

        System.out.println("numbers = " + numbers);
        assertEquals(7, numbers.size());
    }

    @Test
    @DisplayName("수열의 구간 합을 구할 수 있다.")
    void calculate() {
        Progression progression = Progression.of(3, 7);
        int result = progression.calculate();

        assertEquals(15, result);
    }
}
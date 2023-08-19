package baekjoon.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class 등장하지않는문자의합Test {
    private 등장하지않는문자의합 main;

    @BeforeEach
    void setUp() {
        main = new 등장하지않는문자의합();
    }

    @Test
    void calculateTotalAsciiCodeValue() {
        int result = main.calculateTotalAsciiCodeValue();
        assertEquals(2015, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"A, 65", "XYZ, 267"})
    void calculateAppearingAsciiCodeValue(String input, int expected) {
        int actual = main.calculateAppearingAsciiCodeValue(input);
        assertEquals(expected, actual);
    }
}
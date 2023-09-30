package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    private Date date;

    @BeforeEach
    void setUp() {
        date = new Date(2, 18);
    }

    @Test
    @DisplayName("2월 18보다 전이라면 비교 결과는 BEFORE 이다.")
    void compare_before() {
        Date user = new Date(1, 7);
        CompareResult result = date.compare(user);
        assertEquals(CompareResult.BEFORE, result);
    }

    @Test
    @DisplayName("2월 18보다 후라면 비교 결과는 AFTER 이다.")
    void compare_after() {
        Date user = new Date(8, 31);
        CompareResult result = date.compare(user);
        assertEquals(CompareResult.AFTER, result);
    }

    @Test
    @DisplayName("2월 18일과 같은 날이라면 비교 결과는 SPECIAL 이다.")
    void compare_special() {
        Date user = new Date(2, 18);
        CompareResult result = date.compare(user);
        assertEquals(CompareResult.SPECIAL, result);
    }
}
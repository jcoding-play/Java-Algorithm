package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 줄세우기Test {
    private 줄세우기 main;

    @BeforeEach
    void setUp() {
        main = new 줄세우기();
    }

    @Test
    @DisplayName("학생들의 순서를 바꿀 수 있다.")
    void changeOrderV1() {
        int[] students = {1, 2, 3, 4, 5};
        main.changeOrder(students, 0, 2);

        assertEquals(3, students[0]);
        assertEquals(1, students[1]);
        assertEquals(2, students[2]);
    }

    @Test
    @DisplayName("학생들의 순서를 바꿀 수 있다.")
    void changeOrderV2() {
        int[] students = {1, 2, 3, 4, 5};
        main.changeOrder(students, 1, 2);

        assertEquals(1, students[0]);
        assertEquals(3, students[1]);
        assertEquals(2, students[2]);
    }

    @Test
    @DisplayName("학생들의 순서를 바꿀 수 있다.")
    void changeOrderV3() {
        int[] students = {1, 2, 3, 4, 5};
        main.changeOrder(students, 0, 0);

        assertEquals(1, students[0]);
        assertEquals(2, students[1]);
        assertEquals(3, students[2]);
    }
}
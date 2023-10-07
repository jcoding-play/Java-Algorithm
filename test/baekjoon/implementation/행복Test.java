package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class 행복Test {
    private 행복 main;
    private List<Integer> scores;

    @BeforeEach
    void setUp() {
        scores = List.of(27, 35, 92, 75, 42);
        main = new 행복();
    }

    @Test
    @DisplayName("점수들 중에서 가장 큰 점수를 찾을 수 있다.")
    void findMaxScore() {
        int maxScore = main.findMaxScore(scores);
        assertEquals(92, maxScore);
    }

    @Test
    @DisplayName("점수들 중에서 가장 낮은 점수를 찾을 수 있다.")
    void findMinScore() {
        int minScore = main.findMinScore(scores);
        assertEquals(27, minScore);
    }

    @Test
    @DisplayName("점수들 중 가장 큰 점수와 가장 낮은 점수의 차이를 구할 수 있다.")
    void calculateDifference() {
        int result = main.calculateDifference(scores);
        assertEquals(65, result);
    }
}
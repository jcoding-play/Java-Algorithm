package baekjoon.implementation.b16236.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeCalculatorTest {

    @Test
    @DisplayName("상어가 이동하려는 위치 중 최소 이동 가능한 위치와 시간을 알 수 있다.")
    void findMinDistancePoint() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);
        Shark shark = new Shark();

        TimeCalculator timeCalculator = new TimeCalculator(board, shark);
        Point minDistancePoint = timeCalculator.findMinDistancePoint();
        assertEquals(new Point(1, 1), minDistancePoint);
    }

    @Test
    @DisplayName("먹을 수 있는 물고기가 없는 경우 예외가 발생한다.")
    void invalid_V1() {
        int[][] array = {{0, 0, 0}, {0, 0, 0}, {0, 9, 0}};
        Board board = new Board(array);
        Shark shark = new Shark();

        TimeCalculator timeCalculator = new TimeCalculator(board, shark);
        Exception exception = assertThrows(IllegalArgumentException.class, timeCalculator::findMinDistancePoint);
        assertEquals("먹을 수 있는 물고기가 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("먹을 수 있는 물고기가 없는 경우 예외가 발생한다.")
    void invalid_V2() {
        int[][] array = {{1, 1, 0}, {3, 3, 3}, {0, 9, 0}};
        Board board = new Board(array);
        Shark shark = new Shark();

        TimeCalculator timeCalculator = new TimeCalculator(board, shark);
        Exception exception = assertThrows(IllegalArgumentException.class, timeCalculator::findMinDistancePoint);
        assertEquals("먹을 수 있는 물고기가 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("상어가 물고기를 잡아먹는 총 시간을 계산할 수 있다.")
    void calculateTotalTime() {
        int[][] array = {{1, 0, 0}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);
        Shark shark = new Shark();

        TimeCalculator timeCalculator = new TimeCalculator(board, shark);
        int result = timeCalculator.calculateTotalTime();
        assertEquals(3, result);
    }
}
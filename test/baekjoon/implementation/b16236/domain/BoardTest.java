package baekjoon.implementation.b16236.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    @DisplayName("상어가 없으면 예외가 발생한다.")
    void invalidSharkPoint() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 0, 0}};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Board(array));
        assertEquals("상어가 존재하지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("처음 상어의 위치를 찾을 수 있다.")
    void findSharkPoint() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);

        Point sharkPoint = board.findSharkPoint(array);
        assertEquals(new Point(2, 1), sharkPoint);
    }

    @Test
    @DisplayName("상어가 먹을 수 있는 물고기들의 위치를 알 수 있다.")
    void findEdibleFishPoints() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);

        List<Point> points = board.findEdibleFishPoints(2);
        assertEquals(2, points.size());
    }

    @Test
    @DisplayName("상어를 이동시킬 수 있다.")
    void moveSharkTo() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);

        board.moveSharkTo(0, 0);

        Point sharkPoint = board.findSharkPoint(array);
        assertEquals(new Point(0, 0), sharkPoint);
    }

    @Test
    @DisplayName("상어가 해당 위치에 물고기를 먹을 수 있는지 없는지를 알 수 있다.")
    void canSharkEatFish() {
        int[][] array = {{0, 0, 3}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);

        assertFalse(board.canSharkEatFish(0, 2, 2));
        assertTrue(board.canSharkEatFish(1, 1, 2));
    }

    @Test
    @DisplayName("현재 상어의 위치에서 다른 위치로 이동할 때 최소한으로 걸리는 시간들을 알 수 있고, 상어가 못 가는 위치는 0으로 나타낸다.")
    void bfs() {
        int[][] array = {{1, 3}, {0, 9}};
        Board board = new Board(array);

        int[][] distances = board.bfs(new Shark());

        assertEquals(2, distances[0][0]);
        assertEquals(0, distances[0][1]);
        assertEquals(1, distances[1][0]);
    }
}
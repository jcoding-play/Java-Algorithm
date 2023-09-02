package baekjoon.implementation.b16236.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharkTest {
    private Shark shark;

    @BeforeEach
    void setUp() {
        shark = new Shark();
    }

    @Test
    @DisplayName("상어의 기본 크기는 2이다.")
    void create() {
        assertEquals(new Shark(2), shark);
    }

    @Test
    @DisplayName("상어가 이동하려는 위치가 이동가능한지 아닌지를 알 수 있다.")
    void canMove() {
        int[][] array = {{0, 0, 1}, {0, 3, 0}, {0, 9, 0}};
        Board board = new Board(array);

        assertTrue(shark.canMove(board, 0, 2));
        assertFalse(shark.canMove(board, 1, 1));
    }

    @Test
    @DisplayName("상어는 이동할 수 있다.")
    void move() {
        int[][] array = {{0, 0, 1}, {0, 3, 0}, {0, 9, 0}};
        Board board = new Board(array);

        shark.move(board, 0, 0);

        assertEquals(9, array[0][0]);
        assertEquals(0, array[2][1]);
    }

    @Test
    @DisplayName("상어는 자기보다 작은 크기의 물고기를 먹을 수 있다.")
    void eatFish() {
        int[][] array = {{0, 0, 1}, {0, 3, 0}, {0, 9, 0}};
        Board board = new Board(array);

        shark.eatFish(board, 0, 2);

        assertEquals(9, array[0][2]);
        assertEquals(0, array[2][1]);
    }

    @Test
    @DisplayName("상어는 자기보다 크거나 같은 물고기를 먹으려 하면 예외가 발생한다.")
    void validateEatFish() {
        int[][] array = {{0, 0, 1}, {0, 3, 0}, {0, 9, 0}};
        Board board = new Board(array);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> shark.eatFish(board, 1, 1));
        assertEquals("상어의 크기보다 크거나 같은 물고기는 먹을 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("상어가 자신의 크기와 같은 수의 물고기를 먹을때마다 크기가 증가한다.")
    void increaseSize() {
        int[][] array = {{0, 0, 1}, {0, 1, 0}, {0, 9, 0}};
        Board board = new Board(array);

        shark.eatFish(board, 0, 2);
        shark.eatFish(board, 1, 1);

        assertEquals(new Shark(3), shark);
    }
}
package baekjoon.implementation.b14503.domain;

import baekjoon.implementation.b14503.domain.robot.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("현재 바라보는 방향을 알 수 있다.")
    void getDirection(int number) {
        Direction direction = new Direction(number);
        assertEquals(number, direction.getDirection());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("바라보는 방향에 대한 입력이 0에서 3사이의 값이 아니라면 예외가 발생한다.")
    void invalidDirection(int number) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Direction(number));
        assertEquals("바라보는 방향에 대한 입력은 0에서 3사이의 값이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("현재 바라보는 방향을 반시계 방향으로 회전할 수 있다.")
    void turn() {
        Direction direction = new Direction(0);
        direction.turn();

        assertEquals(3, direction.getDirection());
    }
}

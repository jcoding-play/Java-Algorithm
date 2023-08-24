package baekjoon.implementation.b14503.domain;

import baekjoon.implementation.b14503.domain.robot.Point;
import baekjoon.implementation.b14503.domain.strategy.MovingBackwardStrategy;
import baekjoon.implementation.b14503.domain.strategy.MovingForwardStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point(1, 1);
    }

    @Test
    @DisplayName("현재 위치 정보를 알 수 있다.")
    void create() {
        assertEquals(new Point(1, 1), point);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("바라보는 방향에 대한 입력이 0에서 3사이의 값이 아니라면 예외가 발생한다.")
    void validateDirection(int direction) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> point.move(direction, new MovingBackwardStrategy()));
        assertEquals("바라보는 방향에 대한 입력이 유효하지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("현재 바라보는 방향에 맞쳐 뒤로 이동할 수 있다.")
    void moveBackward() {
        point.move(0, new MovingBackwardStrategy());
        assertEquals(new Point(2, 1), point);
    }

    @Test
    @DisplayName("현재 바라보는 방향에 맞쳐 앞으로 이동할 수 있다.")
    void moveForward() {
        point.move(0, new MovingForwardStrategy());
        assertEquals(new Point(0, 1), point);
    }
}

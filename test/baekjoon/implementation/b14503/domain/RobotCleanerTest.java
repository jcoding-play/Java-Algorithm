package baekjoon.implementation.b14503.domain;

import baekjoon.implementation.b14503.domain.robot.Direction;
import baekjoon.implementation.b14503.domain.robot.Point;
import baekjoon.implementation.b14503.domain.robot.RobotCleaner;
import baekjoon.implementation.b14503.domain.robot.Room;
import baekjoon.implementation.b14503.domain.strategy.MovingForwardStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotCleanerTest {
    private RobotCleaner robotCleaner;
    private Room room;
    private Point point;
    private Direction direction;

    @BeforeEach
    void setUp() {
        int[][] roomInfo = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        room = new Room(roomInfo);
        point = new Point(1, 1);
        direction = new Direction(0);

        robotCleaner = new RobotCleaner(point, direction);
    }

    @Test
    @DisplayName("현재 위치가 이미 청소된 곳인지 아닌지를 알 수 있다.")
    void isCleanedPoint() {
        assertFalse(robotCleaner.isCleanedPoint(room));

        robotCleaner.cleanCurrentPoint(room);
        assertTrue(robotCleaner.isCleanedPoint(room));
    }

    @Test
    @DisplayName("현재 위치가 벽일때 청소하면 예외가 발생한다.")
    void validateCleanCurrentPoint_wall() {
        point.move(0, new MovingForwardStrategy());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> robotCleaner.cleanCurrentPoint(room));
        assertEquals("벽이 있는 곳은 청소할 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("현재 위치가 이미 청소한 곳인데 청소하면 예외가 발생한다.")
    void validateCleanCurrentPoint_cleanedAlready() {
        robotCleaner.cleanCurrentPoint(room);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> robotCleaner.cleanCurrentPoint(room));
        assertEquals("이미 청소를 마친 곳입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("로봇 청소기는 앞으로 이동할 수 있다.")
    void moveForward() {
        robotCleaner.moveForward();
        assertEquals(new Point(0, 1), point);
    }

    @Test
    @DisplayName("로봇 청소기는 뒤로 이동할 수 있다.")
    void moveBackward() {
        robotCleaner.moveBackward();
        assertEquals(new Point(2, 1), point);
    }

    @Test
    @DisplayName("로봇 청소기는 반시계 방향으로 회전할 수 있다.")
    void turn() {
        robotCleaner.turn();
        assertEquals(3, direction.getDirection());

        robotCleaner.turn();
        assertEquals(2, direction.getDirection());
    }

    @Test
    @DisplayName("로봇 청소기가 후진할 수 있는지 없는지를 알 수 있다.")
    void canMoveBackward() {
        assertFalse(robotCleaner.canMoveBackward(room));

        robotCleaner.moveForward();
        assertTrue(robotCleaner.canMoveBackward(room));
    }
}

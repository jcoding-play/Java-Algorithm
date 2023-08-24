package baekjoon.implementation.b14503.domain;

import baekjoon.implementation.b14503.domain.robot.Direction;
import baekjoon.implementation.b14503.domain.robot.Point;
import baekjoon.implementation.b14503.domain.robot.RobotCleaner;
import baekjoon.implementation.b14503.domain.robot.Room;
import baekjoon.implementation.b14503.service.CleaningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CleaningServiceTest {
    private CleaningService service;
    private RobotCleaner robotCleaner;
    private Room room;

    @BeforeEach
    void setUp() {
        int[][] roomInfo = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        robotCleaner = new RobotCleaner(new Point(1, 1), new Direction(0));
        room = new Room(roomInfo);
        service = new CleaningService(robotCleaner, room);
    }

    @Test
    void cleanRoom() {
        service.cleanRoom();

        int result = service.getNumberOfCleanedPoint();
        assertEquals(1, result);
    }
}
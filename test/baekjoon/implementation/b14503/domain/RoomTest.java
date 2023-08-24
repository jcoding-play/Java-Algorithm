package baekjoon.implementation.b14503.domain;

import baekjoon.implementation.b14503.domain.robot.Point;
import baekjoon.implementation.b14503.domain.robot.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;
    private int[][] roomInfo = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    @BeforeEach
    void setUp() {
        room = new Room(roomInfo);
    }

    @Test
    @DisplayName("방의 상태를 알 수 있다.")
    void create() {
        assertEquals(new Room(roomInfo), room);
    }

    @Test
    @DisplayName("청소한 위치에 대한 방 상태를 변경할 수 있다.")
    void cleanCurrentPosition() {
        Point point = new Point(1, 1);
        room.cleanCurrentPosition(point);

        assertEquals(2, roomInfo[1][1]);
    }
}
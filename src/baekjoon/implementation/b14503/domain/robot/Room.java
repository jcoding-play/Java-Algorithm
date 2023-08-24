package baekjoon.implementation.b14503.domain.robot;

import java.util.Arrays;

public class Room {
    private final int[][] roomInfo;

    public Room(int[][] roomInfo) {
        this.roomInfo = roomInfo;
    }

    public boolean isCleanedPoint(Point point) {
        return point.isCleanedPoint(roomInfo);
    }

    public boolean isUncleanedPoint(Point point) {
        return point.isUncleanedPoint(roomInfo);
    }

    public void cleanCurrentPosition(Point point) {
        point.cleanCurrentPosition(roomInfo);
    }

    public boolean isWall(Point point) {
        return point.isWall(roomInfo);
    }

    public boolean hasNotUncleanedPointAround(Point point) {
        return point.hasNotUncleanedPointAround(roomInfo);
    }

    public boolean isOutOfRange(Point point) {
        return point.isOutOfRange(roomInfo.length, roomInfo[0].length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Arrays.equals(roomInfo, room.roomInfo);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(roomInfo);
    }
}

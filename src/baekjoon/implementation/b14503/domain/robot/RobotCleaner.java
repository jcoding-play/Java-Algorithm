package baekjoon.implementation.b14503.domain.robot;

import baekjoon.implementation.b14503.domain.strategy.MovingBackwardStrategy;
import baekjoon.implementation.b14503.domain.strategy.MovingForwardStrategy;

public class RobotCleaner {
    private final Point point;
    private final Direction direction;

    public RobotCleaner(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public boolean isCleanedPoint(Room room) {
        return room.isCleanedPoint(point);
    }

    public void cleanCurrentPoint(Room room) {
        validatePoint(room);
        room.cleanCurrentPosition(point);
    }

    private void validatePoint(Room room) {
        if (room.isWall(point)) {
            throw new IllegalArgumentException("벽이 있는 곳은 청소할 수 없습니다.");
        }
        if (room.isCleanedPoint(point)) {
            throw new IllegalArgumentException("이미 청소를 마친 곳입니다.");
        }
    }

    public void moveForward() {
        point.move(direction.getDirection(), new MovingForwardStrategy());
    }

    public void moveBackward() {
        point.move(direction.getDirection(), new MovingBackwardStrategy());
    }

    public void turn() {
        direction.turn();
    }

    public boolean canMoveForward(Room room) {
        int row = point.getRow();
        int column = point.getColumn();
        Point source = new Point(row, column);

        source.move(direction.getDirection(), new MovingForwardStrategy());

        if (room.isOutOfRange(source)) {
            return false;
        }
        return room.isUncleanedPoint(source);
    }

    public boolean canMoveBackward(Room room) {
        int row = point.getRow();
        int column = point.getColumn();
        Point source = new Point(row, column);

        source.move(direction.getDirection(), new MovingBackwardStrategy());

        if (room.isOutOfRange(source)) {
            return false;
        }
        return !room.isWall(source);
    }

    public boolean hasNotUncleanedPointAround(Room room) {
        return room.hasNotUncleanedPointAround(point);
    }
}

package baekjoon.implementation.b14503.domain.robot;

import baekjoon.implementation.b14503.utils.Constants;

public class Direction {
    private int direction;

    public Direction(int direction) {
        validateDirection(direction);
        this.direction = direction;
    }

    private void validateDirection(int direction) {
        if (direction < Constants.NORTH_DIRECTION_NUMBER || direction > Constants.WEST_DIRECTION_NUMBER) {
            throw new IllegalArgumentException("바라보는 방향에 대한 입력은 0에서 3사이의 값이어야 합니다.");
        }
    }

    public void turn() {
        direction--;
        if (direction < Constants.NORTH_DIRECTION_NUMBER) {
            direction = Constants.WEST_DIRECTION_NUMBER;
        }
    }

    public int getDirection() {
        return direction;
    }
}

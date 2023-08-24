package baekjoon.implementation.b14503.domain.strategy;

import baekjoon.implementation.b14503.utils.Constants;

public class MovingForwardStrategy implements MovingStrategy {

    @Override
    public int[] move(int row, int column, int direction) {
        if (direction == Constants.NORTH_DIRECTION_NUMBER) {
            row--;
            return new int[]{row, column};
        }
        if (direction == Constants.EAST_DIRECTION_NUMBER) {
            column++;
            return new int[]{row, column};
        }
        if (direction == Constants.SOUTH_DIRECTION_NUMBER) {
            row++;
            return new int[]{row, column};
        }
        if (direction == Constants.WEST_DIRECTION_NUMBER) {
            column--;
            return new int[]{row, column};
        }
        throw new IllegalArgumentException("바라보는 방향에 대한 입력이 유효하지 않습니다.");
    }
}

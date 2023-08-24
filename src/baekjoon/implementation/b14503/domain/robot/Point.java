package baekjoon.implementation.b14503.domain.robot;

import baekjoon.implementation.b14503.domain.strategy.MovingStrategy;

import java.util.Objects;

public class Point {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static final int CLEANED_POINT_NUMBER = 2;
    private static final int UNCLEANED_POINT_NUMBER = 0;
    private static final int WALL_POINT_NUMBER = 1;

    private int row;
    private int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void move(int direction, MovingStrategy movingStrategy) {
        int[] point = movingStrategy.move(row, column, direction);
        row = point[0];
        column = point[1];
    }

    public boolean isCleanedPoint(int[][] roomInfo) {
        return roomInfo[row][column] == CLEANED_POINT_NUMBER;
    }

    public boolean isUncleanedPoint(int[][] roomInfo) {
        return roomInfo[row][column] == UNCLEANED_POINT_NUMBER;
    }

    public void cleanCurrentPosition(int[][] roomInfo) {
        roomInfo[row][column] = CLEANED_POINT_NUMBER;
    }

    public boolean isWall(int[][] roomInfo) {
        return roomInfo[row][column] == WALL_POINT_NUMBER;
    }

    public boolean hasNotUncleanedPointAround(int[][] roomInfo) {
        for (int i = 0; i < 4; i++) {
            int r = row + DIRECTION_X[i];
            int c = column + DIRECTION_Y[i];

            if (r >= roomInfo.length || c >= roomInfo[0].length) {
                continue;
            }

            if (roomInfo[r][c] == UNCLEANED_POINT_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public boolean isOutOfRange(int x, int y) {
        return row >= x || column >= y;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}

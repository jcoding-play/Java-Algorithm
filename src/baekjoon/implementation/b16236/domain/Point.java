package baekjoon.implementation.b16236.domain;

import baekjoon.implementation.b16236.utils.Constants;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y, int[][] board) {
        board[this.x][this.y] = Constants.EMPTY_NUMBER;
        board[x][y] = Constants.SHARK_NUMBER;

        this.x = x;
        this.y = y;
    }

    public int calculateNextX(int x) {
        return this.x + x;
    }

    public int calculateNextY(int y) {
        return this.y + y;
    }

    public int calculateDistance(int[][] distanceInfo) {
        return distanceInfo[x][y];
    }

    public boolean isMinDistancePoint(int[][] distanceInfo, int distance) {
        return calculateDistance(distanceInfo) == distance;
    }

    public void checkMoved(boolean[][] isMoved) {
        isMoved[x][y] = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return this.y - other.y;
        }
        return this.x - other.x;
    }
}

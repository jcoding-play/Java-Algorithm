package baekjoon.implementation.b16236.domain;

import baekjoon.implementation.b16236.utils.Constants;

import java.util.*;

public class Board {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};
    private static final int MIN_RANGE = 0;

    private final int[][] board;
    private final Point sharkPoint;

    public Board(int[][] board) {
        this.board = board;
        this.sharkPoint = findSharkPoint(board);
    }

    protected Point findSharkPoint(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            Optional<Point> sharkPoint = checkSharkPoint(board, x);

            if (sharkPoint.isPresent()) {
                return sharkPoint.get();
            }
        }
        throw new IllegalArgumentException("상어가 존재하지 않습니다.");
    }

    private Optional<Point> checkSharkPoint(int[][] board, int x) {
        for (int y = 0; y < board.length; y++) {
            if (board[x][y] == Constants.SHARK_NUMBER) {
                return Optional.of(new Point(x, y));
            }
        }
        return Optional.empty();
    }

    public List<Point> findEdibleFishPoints(int sharkSize) {
        List<Point> points = new ArrayList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                addPoint(sharkSize, x, y, points);
            }
        }
        return points;
    }

    private void addPoint(int sharkSize, int x, int y, List<Point> points) {
        if (board[x][y] != Constants.EMPTY_NUMBER && board[x][y] < sharkSize) {
            points.add(new Point(x, y));
        }
    }

    public void moveSharkTo(int x, int y) {
        sharkPoint.move(x, y, board);
    }

    public boolean canSharkEatFish(int x, int y, int size) {
        return board[x][y] < size;
    }

    public int[][] bfs(Shark shark) {
        int n = board.length;
        int[][] distanceInfo = new int[n][n];

        boolean[][] isMoved = new boolean[n][n];
        sharkPoint.checkMoved(isMoved);

        Queue<Point> queue = new LinkedList<>();
        queue.add(sharkPoint);

        while (!queue.isEmpty()) {
            moveNextPoint(queue, distanceInfo, isMoved, shark);
        }

        return distanceInfo;
    }

    private void moveNextPoint(Queue<Point> queue, int[][] distanceInfo, boolean[][] isMoved, Shark shark) {
        Point point = queue.poll();

        for (int i = 0; i < 4; i++) {
            int nextX = point.calculateNextX(DIRECTION_X[i]);
            int nextY = point.calculateNextY(DIRECTION_Y[i]);

            if (isImpossibleToMove(nextX, nextY, shark) || isMoved[nextX][nextY]) {
                continue;
            }
            isMoved[nextX][nextY] = true;
            distanceInfo[nextX][nextY] = point.calculateDistance(distanceInfo) + 1;
            queue.add(new Point(nextX, nextY));
        }
    }

    private boolean isImpossibleToMove(int x, int y, Shark shark) {
        return isOutOfRange(x) || isOutOfRange(y) || !canSharkMoveTo(x, y, shark.getSize());
    }

    private boolean isOutOfRange(int value) {
        return value < MIN_RANGE || value >= board.length;
    }

    public boolean canSharkMoveTo(int x, int y, int size) {
        return board[x][y] <= size;
    }
}

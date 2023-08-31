package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Point sharkPoint;
    private static int N;
    private static int sharkSize = 2;
    private static int numberOfFishEaten = 0;
    private static int time = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(reader.readLine());
        int[][] board = initBoard();

        while (true) {
            List<Point> edibleFishPoints = findEdibleFishPoints(board);
            if (edibleFishPoints.size() == 0) {
                break;
            }
            List<Point> minDistancePoints = findMinDistancePoints(edibleFishPoints, board);
            if (minDistancePoints.size() == 0) {
                break;
            }
            Point point = selectPoint(minDistancePoints);

            eatFish(point, board);
        }

        System.out.println(time);
    }

    private static int[][] initBoard() throws IOException {
        int[][] board = new int[N][N];

        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (board[i][j] == 9) {
                    sharkPoint = new Point(i, j);
                    board[i][j] = 0;
                }
            }
        }
        return board;
    }

    private static List<Point> findEdibleFishPoints(int[][] board) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0 && board[i][j] < sharkSize) {
                    points.add(new Point(i, j));
                }
            }
        }
        return points;
    }

    private static void eatFish(Point point, int[][] board) {
        sharkPoint = point;
        board[point.getX()][point.getY()] = 0;
        numberOfFishEaten++;

        if (numberOfFishEaten == sharkSize) {
            sharkSize++;
            numberOfFishEaten = 0;
        }
    }

    private static Point selectPoint(List<Point> points) {
        Collections.sort(points);
        return points.get(0);
    }

    private static List<Point> findMinDistancePoints(List<Point> points, int[][] board) {
        List<Point> minDistancePoints = new ArrayList<>();

        int[][] dis = new int[N][N];
        bfs(dis, board);

        int min = Integer.MAX_VALUE;
        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();
            int distance = dis[x][y];

            if (distance == 0) {
                continue;
            }
            if (min > distance) {
                min = distance;
                minDistancePoints = new ArrayList<>();
                minDistancePoints.add(point);
                continue;
            }
            if (min == distance) {
                minDistancePoints.add(point);
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        time += min;
        return minDistancePoints;
    }

    private static void bfs(int[][] dis, int[][] board) {
        boolean[][] isMoved = new boolean[N][N];
        int x = sharkPoint.getX();
        int y = sharkPoint.getY();
        dis[x][y] = 0;
        isMoved[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int currentX = position[0];
            int currentY = position[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DIRECTION_X[i];
                int nextY = currentY + DIRECTION_Y[i];

                if (isImpossibleToMove(nextX, nextY, board) || isMoved[nextX][nextY]) {
                    continue;
                }
                isMoved[nextX][nextY] = true;
                dis[nextX][nextY] = dis[currentX][currentY] + 1;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }

    private static boolean isImpossibleToMove(int x, int y, int[][] board) {
        return isOutOfRange(x) || isOutOfRange(y) || board[x][y] > sharkSize;
    }

    private static boolean isOutOfRange(int value) {
        return value < 0 || value >= N;
    }

    static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSamePoint(int x, int y) {
            return this.x == x && this.y == y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
    }
}

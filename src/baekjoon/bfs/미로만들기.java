package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로만들기 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static int n;
    private static int[][] checked;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = br.read() - '0';
            }
            br.read();
        }

        checked = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checked[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0, 0, map);

        System.out.println(answer);
    }

    private static void bfs(int x, int y, int[][] map) {
        checked[x][y] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.calculateNextX(DIRECTION_X[i]);
                int nextY = point.calculateNextY(DIRECTION_Y[i]);

                if (isInvalidRange(nextX, nextY) || point.getCount() >= answer) {
                    continue;
                }
                if (isLastPoint(nextX, nextY)) {
                    answer = Math.min(answer, point.getCount());
                    continue;
                }

                int count = point.getCount();
                if (map[nextX][nextY] == 0) {
                    count++;
                }

                if (checked[nextX][nextY] <= count) {
                    continue;
                }
                checked[nextX][nextY] = count;
                queue.add(new Point(count, nextX, nextY));
            }
        }
    }

    private static boolean isInvalidRange(int x, int y) {
        return isOutOfRangeOfX(x) || isOutOfRangeOfY(y);
    }

    private static boolean isOutOfRangeOfX(int x) {
        return x < 0 || x >= n;
    }

    private static boolean isOutOfRangeOfY(int y) {
        return y < 0 || y >= n;
    }

    private static boolean isLastPoint(int x, int y) {
        return x == n - 1 && y == n - 1;
    }

    static class Point {
        private final int count;
        private final int x;
        private final int y;

        public Point(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
        }

        public int calculateNextX(int directionX) {
            return this.x + directionX;
        }

        public int calculateNextY(int directionY) {
            return this.y + directionY;
        }

        public int getCount() {
            return count;
        }
    }
}

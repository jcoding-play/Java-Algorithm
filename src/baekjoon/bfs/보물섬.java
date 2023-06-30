package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static int N;
    private static int M;
    private static int[][] timeToMove;
    private static boolean[][] isMoved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        printMaxTime(calculateMaxTime(initializeMap(br)));
    }

    private static char[][] initializeMap(BufferedReader br) throws IOException {
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }
        return map;
    }

    private static int calculateMaxTime(char[][] map) {
        int maxTime = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    isMoved = new boolean[N][M];
                    timeToMove = new int[N][M];
                    maxTime = Math.max(maxTime, bfs(i, j, map));
                }
            }
        }
        return maxTime;
    }

    private static int bfs(int x, int y, char[][] map) {
        isMoved[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        int max = 0;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int currentX = currentPoint.getX();
            int currentY = currentPoint.getY();

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DIRECTION_X[i];
                int nextY = currentY + DIRECTION_Y[i];

                if (isImpossibleToMove(nextX, nextY, map) || isMoved[nextX][nextY]) {
                    continue;
                }

                isMoved[nextX][nextY] = true;
                timeToMove[nextX][nextY] = timeToMove[currentX][currentY] + 1;
                queue.add(new Point(nextX, nextY));

                max = Math.max(max, timeToMove[nextX][nextY]);
            }
        }
        return max;
    }

    private static boolean isImpossibleToMove(int x, int y, char[][] map) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y) || map[x][y] == 'W';
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x < 0 || x >= N;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y < 0 || y >= M;
    }

    private static void printMaxTime(int maxTime) {
        System.out.println(maxTime);
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

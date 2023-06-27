package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 침투 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static int M;
    private static int N;
    private static boolean[][] isMoved;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        checkForMobility(initializeMap(br));
        printResult();
    }

    private static int[][] initializeMap(BufferedReader br) throws IOException {
        int[][] map = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = br.read() - '0';
            }
            br.read();
        }
        return map;
    }

    private static void checkForMobility(int[][] map) {
        for (int col = 0; col < N; col++) {
            if (map[0][col] == 0) {
                isMoved = new boolean[M][N];
                isMoved[0][col] = true;
                dfs(0, col, map);
            }

            if (flag) return;
        }
    }

    private static void dfs(int x, int y, int[][] map) {
        if (flag) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION_X[i];
            int ny = y + DIRECTION_Y[i];

            if (isImpossibleToMove(nx, ny, map) || isMoved[nx][ny]) {
                continue;
            }
            move(map, nx, ny);
        }
    }

    private static void move(int[][] map, int nx, int ny) {
        isMoved[nx][ny] = true;
        if (nx == M - 1) {
            flag = true;
        }

        dfs(nx, ny, map);
    }

    private static boolean isImpossibleToMove(int x, int y, int[][] map) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y) || map[x][y] == 1;
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x < 0 || x >= M;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y < 0 || y >= N;
    }

    private static void printResult() {
        if (flag) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}

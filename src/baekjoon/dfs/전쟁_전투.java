package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전쟁_전투 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static int N;
    private static int M;
    private static int count;
    private static boolean[][] isChecked;
    private static int ourForcesPower = 0;
    private static int enemyPower = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isChecked = new boolean[M][N];

        calculatePower(initializeMap(br));
        showPower();
    }

    private static char[][] initializeMap(BufferedReader br) throws IOException {
        char[][] map = new char[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }
        return map;
    }

    private static void calculatePower(char[][] map) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isChecked[i][j]) {
                    isChecked[i][j] = true;
                    count = 1;
                    dfs(i, j, map, map[i][j]);

                    addPower(map[i][j], count);
                }
            }
        }
    }

    private static void dfs(int x, int y, char[][] map, char teamColor) {
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION_X[i];
            int ny = y + DIRECTION_Y[i];

            if (isOutOfRange(nx, ny) || isNotSameTeam(map[nx][ny], teamColor) || isChecked[nx][ny]) {
                continue;
            }

            isChecked[nx][ny] = true;
            count++;
            dfs(nx, ny, map, map[nx][ny]);
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y);
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x < 0 || x >= M;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y < 0 || y >= N;
    }

    private static boolean isNotSameTeam(char color, char otherColor) {
        return color != otherColor;
    }

    private static void addPower(char teamColor, int count) {
        int plusPower = count * count;

        if (teamColor == 'W') {
            ourForcesPower += plusPower;
            return;
        }
        enemyPower += plusPower;
    }

    private static void showPower() {
        System.out.printf("%d %d", ourForcesPower, enemyPower);
    }
}

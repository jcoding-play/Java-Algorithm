package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {
    private static int N;
    private static int maxCount = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][N];
        int[][] map = initializeMap(br);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, map);
            }
        }
        System.out.println(maxCount + 1);
    }

    private static int[][] initializeMap(BufferedReader br) throws IOException {
        int[][] map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }

    private static void dfs(int x, int y, int[][] map) {
        if (dp[x][y] > 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInvalidRange(nx, ny) || map[x][y] >= map[nx][ny]) {
                continue;
            }

            dfs(nx, ny, map);
            dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
            maxCount = Math.max(maxCount, dp[x][y]);
        }
    }

    private static boolean isInvalidRange(int x, int y) {
        return exceedRange(x) || exceedRange(y);
    }

    private static boolean exceedRange(int value) {
        return value < 0 || value >= N;
    }
}

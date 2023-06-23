package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물피하기 {
    private static int N;
    private static int M;
    private static int count;
    private static int maxSize = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    count = 1;
                    dfs(i, j, map);
                    maxSize = Math.max(maxSize, count);
                }
            }
        }
        System.out.println(maxSize);
    }

    private static void dfs(int x, int y, int[][] map) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInvalidRange(nx, ny) || map[nx][ny] == 0) {
                continue;
            }

            map[nx][ny] = 0;
            count++;
            dfs(nx, ny, map);
        }
    }

    private static boolean isInvalidRange(int x, int y) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y);
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x <= 0 || x > N;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y <= 0 || y > M;
    }
}

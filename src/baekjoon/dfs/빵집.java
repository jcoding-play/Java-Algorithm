package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {
    private static final int[] DIRECTION_X = {-1, 0, 1};
    private static final int[] DIRECTION_Y = {1, 1, 1};

    private static int R;
    private static int C;
    private static boolean[][] isMoved;

    private static boolean flag;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isMoved = new boolean[R][C];

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }

        for (int row = 0; row < R; row++) {
            flag = false;
            isMoved[row][0] = true;
            dfs(row, 0, map);
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int col, char[][] map) {
        if (col == C - 1) {
            answer++;
            flag = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextRow = row + DIRECTION_X[i];
            int nextCol = col + DIRECTION_Y[i];

            if (isImpossibleToMove(nextRow, nextCol, map) || isMoved[nextRow][nextCol]) {
                continue;
            }

            isMoved[nextRow][nextCol] = true;
            dfs(nextRow, nextCol, map);
            if (flag) {
                return;
            }
        }
    }

    private static boolean isImpossibleToMove(int x, int y, char[][] map) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y) || map[x][y] == 'x';
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x < 0 || x >= R;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y < 0 || y >= C;
    }
}

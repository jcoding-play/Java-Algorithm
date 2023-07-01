package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판점프 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static String[][] board = new String[5][5];
    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initBoard(br);

        calculateResult();
        System.out.println(result.size());
    }

    private static void initBoard(BufferedReader br) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken();
            }
        }
    }

    private static void calculateResult() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, board[i][j]);
            }
        }
    }

    private static void dfs(int x, int y, String numbers) {
        if (numbers.length() == 6) {
            result.add(numbers);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION_X[i];
            int ny = y + DIRECTION_Y[i];

            if (isInvalidRange(nx, ny)) {
                continue;
            }

            dfs(nx, ny, numbers + board[nx][ny]);
        }
    }

    private static boolean isInvalidRange(int x, int y) {
        return isOutOfRange(x) || isOutOfRange(y);
    }

    private static boolean isOutOfRange(int value) {
        return value < 0 || value >= 5;
    }
}

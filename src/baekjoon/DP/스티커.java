package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {

    static int[][] score;
    static int[][] dy;
    static StringBuilder sb = new StringBuilder();
    static final int NUMBER = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            score = new int[NUMBER + 1][n + 1];
            for (int i = 1; i <= NUMBER; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dy = new int[NUMBER + 1][n + 1];
            solution(n);
        }
        System.out.print(sb);
    }

    private static void solution(int n) {
        dy[1][1] = score[1][1];
        dy[2][1] = score[2][1];

        for (int i = 2; i <= n; i++) {
            dy[1][i] = Math.max(dy[2][i - 1], dy[2][i - 2]) + score[1][i];
            dy[2][i] = Math.max(dy[1][i - 1], dy[1][i - 2]) + score[2][i];
        }

        int max = Math.max(dy[1][n], dy[2][n]);
        sb.append(max).append('\n');
    }
}

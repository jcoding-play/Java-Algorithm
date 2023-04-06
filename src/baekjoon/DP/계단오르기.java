package baekjoon.DP;

import java.io.*;

public class 계단오르기 {

    static int[][] dy = new int[301][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dy[1][1] = score[1];
        if (n >= 2) {
            dy[2][1] = score[2];
            dy[2][2] = score[1] + score[2];
        }
        System.out.println(solution(score, n));
    }

    private static int solution(int[] score, int n) {
        for (int i = 3; i <= n; i++) {
            dy[i][1] = Math.max(dy[i - 2][1], dy[i - 2][2]) + score[i];
            dy[i][2] = dy[i - 1][1] + score[i];
        }
        return Math.max(dy[n][1], dy[n][2]);
    }
}

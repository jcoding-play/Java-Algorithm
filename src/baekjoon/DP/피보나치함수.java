package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {

    static int[][] dy = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int max = 0;
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        solution(max);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dy[arr[i]][0]).append(' ').append(dy[arr[i]][1]).append('\n');
        }
        System.out.print(sb);
    }

    private static void solution(int n) {
        dy[0][0] = 1;
        dy[0][1] = 0;
        dy[1][0] = 0;
        dy[1][1] = 1;
        dy[2][0] = 1;
        dy[2][1] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dy[i][j] = dy[i - 1][j] + dy[i - 2][j];
            }
        }
    }
}

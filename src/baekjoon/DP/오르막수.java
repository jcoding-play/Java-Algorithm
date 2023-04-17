package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막수 {

    static int[][] dy;
    static final int lastNum = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new int[n + 1][lastNum + 1];
        solution(n);
    }

    private static void solution(int n) {
        for (int i = 0; i <= lastNum; i++) dy[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int last = 0; last <= lastNum; last++) {
                int sum = 0;
                for (int j = last; j >= 0; j--) {
                    sum += dy[i - 1][j];
                }
                dy[i][last] = sum % 10007;
            }
        }

        System.out.println(Arrays.stream(dy[n]).sum() % 10007);
    }
}

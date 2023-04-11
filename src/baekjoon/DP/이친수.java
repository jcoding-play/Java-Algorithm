package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    static long[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int lastNum = 2;

        dy = new long[n + 1][lastNum];
        solution(n);
    }

    private static void solution(int n) {
        dy[1][0] = 0;
        dy[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dy[i][0] = dy[i - 1][1] + dy[i - 1][0];
            dy[i][1] = dy[i - 1][0];
        }

        System.out.println(dy[n][0] + dy[n][1]);
    }
}

package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수2 {

    static long[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new long[n + 1];
        solution(n);
    }

    private static void solution(int n) {
        dy[0] = 0;
        dy[1] = 1;

        for (int i = 2; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        System.out.println(dy[n]);
    }
}

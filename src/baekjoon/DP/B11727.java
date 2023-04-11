package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11727 - 2*n 타일링 2
 */
public class B11727 {

    static int[] dy = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        solution(n);
    }

    private static void solution(int n) {
        dy[1] = 1;
        dy[2] = 3;

        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 2] * 2 + dy[i - 1]) % 10007;
        }
        System.out.println(dy[n]);
    }
}

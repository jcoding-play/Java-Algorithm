package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1463 - 1로 만들기
 */
public class B1463 {

    static int[] dy = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        solution(n);
    }

    private static void solution(int n) {
        dy[1] = 0;
        dy[2] = 1;
        dy[3] = 1;

        for (int i = 4; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;

            if (i % 3 == 0) tmp = Math.min(dy[i / 3], tmp);
            if (i % 2 == 0) tmp = Math.min(dy[i / 2], tmp);
            tmp = Math.min(dy[i - 1], tmp);

            dy[i] = tmp + 1;
        }

        System.out.println(dy[n]);
    }
}

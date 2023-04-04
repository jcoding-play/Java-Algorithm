package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 15988번 - 1,2,3 더하기 - 3
 */
public class B15988 {

    static long[] dy = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        StringBuilder sb = new StringBuilder();
        int max = 4;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(solution(n, max)).append('\n');
            max = Math.max(max, n);
        }
        System.out.print(sb);
    }

    private static long solution(int n, int s) {
        if(dy[n] > 0) return dy[n];

        for (int i = s; i <= n; i++) {
            dy[i] = (dy[i - 3] + dy[i - 2] + dy[i - 1]) % 1000000009;
        }
        return dy[n];
    }
}

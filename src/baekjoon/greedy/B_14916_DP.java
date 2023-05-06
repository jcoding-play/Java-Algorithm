package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 14916 - 거스름돈
 */
public class B_14916_DP {

    static int[] coin = {2, 5};
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new int[n + 1];
        Arrays.fill(dy, 100000);
        dy[0] = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = coin[i]; j <= n; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        if (dy[n] == 100000) {
            dy[n] = -1;
        }
        System.out.println(dy[n]);
    }
}

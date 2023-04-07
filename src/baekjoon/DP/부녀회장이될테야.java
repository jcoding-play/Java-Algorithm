package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {

    static int[][] dy = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i < 15; i++) dy[0][i] = i;
        dataInit();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dy[k][n]).append('\n');
        }
        System.out.print(sb);
    }

    private static void dataInit() {
        for (int k = 1; k < 15; k++) {
            for (int n = 1; n < 15; n++) {
                dy[k][n] = dy[k - 1][n] + dy[k][n - 1];
            }
        }
    }
}

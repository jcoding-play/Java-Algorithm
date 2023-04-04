package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {

    static long[] dy = new long[101];

    public static void main(String[] args) throws IOException {
        dataInit();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append('\n');
        }
        System.out.print(sb);
    }

    private static void dataInit() {
        dy[1] = 1;
        dy[2] = 1;
        dy[3] = 1;
        for (int i = 4; i <= 100; i++) {
            dy[i] = dy[i - 3] + dy[i - 2];
        }
    }
}

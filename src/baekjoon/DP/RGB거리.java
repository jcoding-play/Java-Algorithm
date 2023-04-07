package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {

    static int[][] rgb;
    static int[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rgb = new int[n + 1][n + 1];
        dy = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
            rgb[i][3] = Integer.parseInt(st.nextToken());
        }

        solution(n);
        System.out.println(Math.min(dy[n][1], Math.min(dy[n][2], dy[n][3])));
    }

    private static void solution(int n) {
        dy[1][1] = rgb[1][1];
        dy[1][2] = rgb[1][2];
        dy[1][3] = rgb[1][3];

        for (int i = 2; i <= n; i++) {
            dy[i][1] = Math.min(dy[i - 1][2], dy[i - 1][3]) + rgb[i][1];
            dy[i][2] = Math.min(dy[i - 1][1], dy[i - 1][3]) + rgb[i][2];
            dy[i][3] = Math.min(dy[i - 1][1], dy[i - 1][2]) + rgb[i][3];
        }
    }
}

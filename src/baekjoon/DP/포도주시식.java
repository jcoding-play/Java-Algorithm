package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {

    static int[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new int[n + 1][2];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(n, arr);
    }

    private static void solution(int n, int[] arr) {
        dy[1][0] = arr[1];
        if (n >= 2) {
            dy[2][0] = arr[2];
            dy[2][1] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dy[i][0] = Math.max(dy[i - 2][0], dy[i - 2][1]) + arr[i];
            dy[i][0] = Math.max(dy[i][0], Math.max(dy[i - 3][0], dy[i - 3][1]) + arr[i]);
            dy[i][1] = dy[i - 1][0] + arr[i];
        }

        System.out.println(Math.max(dy[n - 1][1], Math.max(dy[n][0], dy[n][1])));
    }
}

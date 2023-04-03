package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9095번 - 1,2,3 더하기
 */
public class B9095 {

    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        dy = new int[max + 1];
        solution(max);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dy[arr[i]]).append('\n');
        }
        System.out.print(sb);
    }

    private static void solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= n; i++) {
            dy[i] = dy[i - 3] + dy[i - 2] + dy[i - 1];
        }
    }
}

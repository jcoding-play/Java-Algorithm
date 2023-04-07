package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    static int[] dy;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy = new int[n + 1];
        solution(arr);
        System.out.println(answer);
    }

    private static void solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            dy[i] = Math.max(dy[i - 1] + arr[i], arr[i]);

            answer = Math.max(answer, dy[i]);
        }
    }
}

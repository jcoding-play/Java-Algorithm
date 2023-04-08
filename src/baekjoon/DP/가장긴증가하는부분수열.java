package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    static int[] dy;

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
    }

    private static void solution(int[] arr) {
        int len = arr.length;

        dy[1] = 1;
        int answer = dy[1];
        for (int i = 2; i < len; i++) {
            dy[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (arr[j] < arr[i] && (dy[j] + 1) > dy[i]) {
                    dy[i] = dy[j] + 1;
                }
            }
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }
}

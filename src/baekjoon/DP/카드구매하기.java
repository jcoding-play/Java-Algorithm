package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {

    static int[] dy = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[1] = arr[1];
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        for (int i = 2; i <= n; i++) {
            int max = arr[i];
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dy[i - j] + arr[j]);
            }
            dy[i] = max;
        }

        return dy[n];
    }
}

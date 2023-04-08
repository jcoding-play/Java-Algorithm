package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {

    static int[] dy_inc; //증가하는 부분 수열
    static int[] dy_dec; //감소하는 부분 수열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy_inc = new int[n + 1];
        dy_dec = new int[n + 1];
        solution(arr);
    }

    private static void solution(int[] arr) {
        int len = arr.length;
        setIncreaseDP(arr, len);
        setDecreaseDP(arr, len);

        int answer = 0;
        for (int i = 1; i < len; i++) {
            answer = Math.max(answer, dy_inc[i] + dy_dec[i]);
        }
        System.out.println(answer - 1);
    }

    private static void setIncreaseDP(int[] arr, int len) {
        dy_inc[1] = 1;
        for (int i = 2; i < len; i++) {
            dy_inc[i] = 1;

            for (int j = i - 1; j >= 1; j--) {
                if (arr[j] < arr[i] && (dy_inc[j] + 1) > dy_inc[i]) {
                    dy_inc[i] = dy_inc[j] + 1;
                }
            }
        }
    }

    private static void setDecreaseDP(int[] arr, int len) {
        dy_dec[len - 1] = 1;
        for (int i = len - 2; i >= 1; i--) {
            dy_dec[i] = 1;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i] && (dy_dec[j] + 1) > dy_dec[i]) {
                    dy_dec[i] = dy_dec[j] + 1;
                }
            }
        }
    }
}

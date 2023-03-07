package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {

    static int n, s;
    static int[] arr, ch;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        ch = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solution(0, 0);
        System.out.println(answer);
    }

    private static void solution(int L, int sum) {
        if (L == n) {
            boolean flag = false;
            for (int x : ch) {
                if (x == 1) {
                    flag = true;
                }
            }
            if (flag && sum == s) {
                answer++;
            }
        } else {
            ch[L] = 1;
            solution(L+1, sum+arr[L]);
            ch[L] = 0;
            solution(L+1, sum);
        }
    }
}

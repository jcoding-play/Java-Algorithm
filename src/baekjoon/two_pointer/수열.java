package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            if (rt < k) {
                sum += arr[rt];
                max = sum;
                continue;
            }

            sum += (arr[rt] - arr[lt++]);
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}

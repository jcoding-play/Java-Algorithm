package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long[] answer = new long[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            int lt = i + 1;
            int rt = n - 1;

            while (lt < rt) {
                long sum = arr[i] + arr[lt] + arr[rt];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);

                    answer[0] = arr[i];
                    answer[1] = arr[lt];
                    answer[2] = arr[rt];
                }

                if (sum > 0) rt--;
                else lt++;
            }
        }

        Arrays.sort(answer);
        for (long x : answer) {
            System.out.print(x + " ");
        }
    }
}

package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            while (sum >= s) {
                answer = Math.min(answer, rt - lt + 1);
                sum -= arr[lt++];
            }
        }

        if(answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}

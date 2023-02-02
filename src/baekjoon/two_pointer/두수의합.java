package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        int sum;
        int answer = 0;
        while (lt < rt) {
            sum = arr[lt] + arr[rt];
            if (sum == x) {
                answer++;
                lt++;
                rt--;
            } else if (sum > x) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(answer);
    }
}

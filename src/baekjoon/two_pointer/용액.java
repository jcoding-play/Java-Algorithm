package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int lt = 0;
        int rt = arr.length - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if (sum > 0) {
                rt--;
            } else if (sum < 0) {
                lt++;
            } else {
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}

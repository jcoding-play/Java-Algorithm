package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);
        int answer = 0;
        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (rope[i] * count > answer) {
                answer = rope[i] * count;
            }
            count++;
        }
        System.out.println(answer);
    }
}

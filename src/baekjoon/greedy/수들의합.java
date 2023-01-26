package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int answer = 0;
        int count = 1;
        long sum = 0L;
        while (true) {
            sum += count++;
            if (sum > S) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

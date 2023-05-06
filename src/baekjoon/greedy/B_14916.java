package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 14916 - 거스름돈
 */
public class B_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        for (int fiveCount = 0; fiveCount <= n / 5; fiveCount++) {
            int fiveWon = 5 * fiveCount;
            int remainWon = n - fiveWon;

            if (remainWon % 2 == 0) {
                answer = Math.min(answer, fiveCount + remainWon / 2);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }
}

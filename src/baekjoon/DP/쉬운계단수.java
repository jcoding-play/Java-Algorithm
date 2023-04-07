package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {

    static int[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int lastNum = 10;
        dy = new int[n + 1][lastNum + 1];
        solution(n);
    }

    private static void solution(int n) {
        for (int lastNum = 1; lastNum <= 9; lastNum++) {
            dy[1][lastNum] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int lastNum = 0; lastNum <= 9; lastNum++) {
                if (lastNum == 0) {
                    dy[i][lastNum] = (dy[i - 1][lastNum + 1]) % 1000000000;
                    continue;
                }

                dy[i][lastNum] = (dy[i - 1][lastNum - 1] + dy[i - 1][lastNum + 1]) % 1000000000;
            }
        }

        int answer = 0;
        for (int lastNum = 0; lastNum <= 9; lastNum++) {
            answer = (answer + dy[n][lastNum]) % 1000000000;
        }
        System.out.println(answer);
    }
}

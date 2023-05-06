package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (level[i] >= level[i + 1]) {
                int downLevel = level[i] - level[i + 1] + 1;
                answer += downLevel;

                level[i] = level[i] - downLevel;
            }
        }
        System.out.println(answer);
    }
}

package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

    static int[] dy = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        dy[1] = -1;
        dy[2] = -1;
        dy[3] = 1;
        dy[4] = -1;
        dy[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dy[i - 3] == -1 && dy[i - 5] == -1) {
                dy[i] = -1;
            } else if (dy[i - 3] == -1 || dy[i - 5] == -1) {
                dy[i] = Math.max(dy[i - 3], dy[i - 5]) + 1;
            } else {
                dy[i] = Math.min(dy[i - 3], dy[i - 5]) + 1;
            }
        }
        return dy[n];
    }
}

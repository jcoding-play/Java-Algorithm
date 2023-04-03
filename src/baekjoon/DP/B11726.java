package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11726번 - 2*n 타일링
 */
public class B11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(int n) {
        int[] dy = new int[1001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 3;

        for (int i = 4; i <= n; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % 10007;
        }
        return dy[n];
    }
}

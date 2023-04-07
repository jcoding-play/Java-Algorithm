package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {

    static int[][] dy;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new int[n + 1][];
        triangle = new int[n + 1][];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            dy[i] = new int[i + 1];
            triangle[i] = new int[i + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n);
    }

    private static void solution(int n) {
        dy[1][1] = triangle[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dy[i][j] = dy[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dy[i][j] = dy[i - 1][j - 1] + triangle[i][j];
                } else {
                    dy[i][j] = Math.max(dy[i - 1][j - 1], dy[i - 1][j]) + triangle[i][j];
                }
            }
        }

        System.out.println(Arrays.stream(dy[n]).max().getAsInt());
    }
}

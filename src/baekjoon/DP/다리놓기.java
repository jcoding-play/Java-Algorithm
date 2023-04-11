package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

    static int[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dy = new int[a + 1][b + 1];
            sb.append(solution(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    private static int solution(int a, int b) {
        if (dy[a][b] > 0) return dy[a][b];
        if (a == 1 || a + 1 == b) return dy[a][b] = b;
        if (a == b) return dy[a][b] = 1;

        return dy[a][b] = solution(a - 1, b - 1) + solution(a, b - 1);
    }
}

package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        solution(0);
        System.out.println(sb);
    }

    private static void solution(int L) {
        if (L == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                solution(L + 1);
            }
        }
    }
}

package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] P = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = P.clone();
        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        for (int x : P) {
            for (int i = 0; i < B.length; i++) {
                if (B[i] == x) {
                    sb.append(i).append(' ');
                    B[i] = 0;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}

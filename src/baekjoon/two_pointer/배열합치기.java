package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int A_lt = 0;
        int B_lt = 0;
        while (A_lt < n && B_lt < m) {
            if (A[A_lt] <= B[B_lt]) {
                sb.append(A[A_lt++]).append(' ');
            } else {
                sb.append(B[B_lt++]).append(' ');
            }
        }

        while (A_lt < n) sb.append(A[A_lt++]).append(' ');
        while (B_lt < m) sb.append(B[B_lt++]).append(' ');

        System.out.print(sb);
    }
}

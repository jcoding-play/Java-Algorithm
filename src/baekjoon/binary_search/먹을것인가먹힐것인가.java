package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);
            sb.append(binarySearch(A, B)).append('\n');
        }
        System.out.print(sb);
    }

    private static int binarySearch(int[] A, int[] B) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i >= 1 && A[i - 1] == A[i]) {
                sum += count;
                continue;
            }

            int lt = 0;
            int rt = B.length - 1;

            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (B[mid] < A[i]) {
                    count = mid + 1;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            sum += count;
        }
        return sum;
    }
}

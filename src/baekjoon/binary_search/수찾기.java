package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for (int x : binarySearch(A, B)) {
            System.out.println(x);
        }
    }

    private static int[] binarySearch(int[] A, int[] B) {
        int[] answer = new int[B.length];

        int i = 0;
        for (int x : B) {
            int lt = 0;
            int rt = A.length - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (A[mid] == x) {
                    answer[i] = 1;
                    break;
                } else if (A[mid] > x) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            i++;
        }
        return answer;
    }
}

package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
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
        StringBuilder sb = new StringBuilder();
        for (int x : B) {
            if (binarySearch(x, A)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int card, int[] cards) {
        int lt = 0;
        int rt = cards.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (cards[mid] == card) {
                return true;
            } else if (cards[mid] > card) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return false;
    }
}

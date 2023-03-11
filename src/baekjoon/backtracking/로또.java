package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {

    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] arr, selectedNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 1) break;

            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            selectedNum = new int[6];
            solution(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void solution(int L, int s) {
        if (L == 6) {
            for (int x : selectedNum) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = s; i < k; i++) {
                selectedNum[L] = arr[i];
                solution(L + 1, i + 1);
            }
        }
    }
}

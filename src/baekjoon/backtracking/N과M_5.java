package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr, selectedNum;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ch = new boolean[n];
        selectedNum = new int[m];
        solution(0);
        System.out.print(sb);
    }

    private static void solution(int L) {
        if (L == m) {
            for (int x : selectedNum) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == false) {
                    ch[i] = true;
                    selectedNum[L] = arr[i];
                    solution(L + 1);
                    ch[i] = false;
                }
            }
        }
    }
}

package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_9 {

    static int n, m;
    static int[] arr, selectedNum;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ch = new boolean[n];
        selectedNum = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int L) {
        if (L == m) {
            for (int x : selectedNum) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            int last = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == last) continue;

                if (ch[i] == false) {
                    ch[i] = true;
                    last = arr[i];
                    selectedNum[L] = arr[i];
                    solution(L + 1);
                    ch[i] = false;
                }
            }
        }
    }
}

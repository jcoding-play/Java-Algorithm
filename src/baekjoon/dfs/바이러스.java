package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

    static int[][] computers;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ch = new boolean[n+1];
        computers = new int[n+1][n+1];
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a][b] = 1;
            computers[b][a] = 1;
        }
        ch[1] = true;
        DFS(1, n);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (ch[i] == true) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v, int n) {
        for (int i = 1; i <= n; i++) {
            if (computers[v][i] == 1 && ch[i] == false) {
                ch[i] = true;
                DFS(i, n);
            }
        }
    }
}

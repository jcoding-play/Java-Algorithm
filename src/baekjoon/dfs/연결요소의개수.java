package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    static int[][] graph;
    static boolean[] ch;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        ch = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (ch[i] == false) {
                ch[i] = true;
                answer++;
                DFS(i, N);
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int i, int N) {
        for (int j = 1; j <= N; j++) {
            if (graph[i][j] == 1 && ch[j] == false) {
                ch[j] = true;
                DFS(j, N);
            }
        }
    }
}

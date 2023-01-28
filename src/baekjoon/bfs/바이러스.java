package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        BFS(1, n);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (ch[i] == true) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void BFS(int v, int n) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int tmp = Q.poll();
                for (int j = 1; j <= n; j++) {
                    if (computers[tmp][j] == 1 && ch[j] == false) {
                        ch[j] = true;
                        Q.offer(j);
                    }
                }
            }
        }
    }
}

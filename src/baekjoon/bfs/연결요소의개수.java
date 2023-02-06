package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch = new int[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                count++;
                BFS(i);
            }
        }
        System.out.println(count);
    }

    private static void BFS(int L) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(L);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int nx : graph.get(x)) {
                if (ch[nx] == 0) {
                    ch[nx] = 1;
                    Q.offer(nx);
                }
            }
        }
    }
}

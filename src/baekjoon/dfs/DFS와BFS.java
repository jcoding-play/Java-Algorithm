package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선은 양방향이므로 다음과 같이 입력해준다.
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        /**
         * 문제에서 주어진대로 방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문하기 위해 정렬해준다.
         */
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();
        ch = new int[N+1];
        DFS(V);
        System.out.println(sb);

        sb = new StringBuilder();
        ch = new int[N+1];
        BFS(V);
        System.out.println(sb);
    }

    private static void DFS(int V) {
        ch[V] = 1;
        sb.append(V).append(" ");
        for (int x : graph.get(V)) {
            if (ch[x] == 0) {
                DFS(x);
            }
        }
    }

    private static void BFS(int V) {
        ch[V] = 1;
        sb.append(V).append(" ");
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(V);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int nx : graph.get(x)) {
                if (ch[nx] == 0) {
                    sb.append(nx).append(" ");
                    ch[nx] = 1;
                    Q.offer(nx);
                }
            }
        }
    }
}

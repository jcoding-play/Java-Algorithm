package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_bfs {

    static int[] parentNode;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        parentNode = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parentNode[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs() {
        parentNode[1] = 1;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        while (!Q.isEmpty()) {
            int nowNode = Q.poll();

            for (int nextNode : tree.get(nowNode)) {
                if (parentNode[nextNode] == 0) {
                    parentNode[nextNode] = nowNode;
                    Q.offer(nextNode);
                }
            }
        }
    }
}

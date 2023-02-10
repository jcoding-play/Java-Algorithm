package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] treeParent;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        treeParent = new int[n+1];
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        treeParent[1] = 1;
        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(treeParent[i]);
        }
    }

    private static void BFS(int L) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(L);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int nx : tree.get(x)) {
                if (treeParent[nx] == 0) {
                    treeParent[nx] = x;
                    Q.offer(nx);
                }
            }
        }
    }
}

package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사회망서비스 {
    private static List<List<Integer>> tree;
    private static int[][] dp;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        initData(N);

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void initData(int N) {
        dp = new int[N + 1][2];
        isVisited = new boolean[N + 1];

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
    }

    private static void dfs(int node) {
        isVisited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;

        for (int nextNode : tree.get(node)) {
            if (isVisited[nextNode]) {
                continue;
            }

            dfs(nextNode);
            dp[node][0] += dp[nextNode][1];
            dp[node][1] += Math.min(dp[nextNode][0], dp[nextNode][1]);
        }
    }
}

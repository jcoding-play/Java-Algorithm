package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {
    private static List<List<Node>> tree;
    private static boolean[] isMoved;
    private static int max;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        initializeTree(br, N);

        for (int i = 1; i <= N; i++) {
            findMaximumDiameterOfTree(N, i);
        }
        System.out.println(answer);
    }

    private static void initializeTree(BufferedReader br, int N) throws IOException {
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Node(b, c));
            tree.get(b).add(new Node(a, c));
        }
    }

    private static void findMaximumDiameterOfTree(int N, int node) {
        max = 0;
        isMoved = new boolean[N + 1];
        isMoved[node] = true;
        dfs(node, 0);

        answer = Math.max(answer, max);
    }

    private static void dfs(int vertex, int sum) {
        max = Math.max(max, sum);

        for (Node node : tree.get(vertex)) {
            int nextNode = node.getNode();
            if (isMoved[nextNode]) {
                continue;
            }

            isMoved[nextNode] = true;
            dfs(nextNode, sum + node.getWeight());
        }
    }

    static class Node {
        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }
    }
}

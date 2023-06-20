package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
    private static int max = 0;
    private static int maxNode = 0;
    private static int answer = 0;
    private static boolean[] isMoved;
    private static List<List<Node>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int length = st.countTokens();

            int node = Integer.parseInt(st.nextToken());
            for (int j = 1; j < length - 1; j = j + 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree.get(node).add(new Node(a, b));
                tree.get(a).add(new Node(node, b));
            }
        }

        isMoved = new boolean[V + 1];
        isMoved[1] = true;
        dfs(1, 0);

        isMoved = new boolean[V + 1];
        isMoved[maxNode] = true;
        dfs(maxNode, 0);

        System.out.println(max);
    }

    private static void dfs(int vertex, int sum) {
        if (sum > max) {
            max = sum;
            maxNode = vertex;
        }

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

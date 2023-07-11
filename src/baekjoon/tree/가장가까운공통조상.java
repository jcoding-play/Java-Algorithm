package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class 가장가까운공통조상 {
    private static List<List<Integer>> tree;
    private static int[] level;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            initializeTree(br, N);

            calculateNodeLevel(findRootNode(N));
            recordCommonParentNode(findCommonParentNode(br), resultBuilder);
        }

        System.out.print(resultBuilder);
    }

    private static void initializeTree(BufferedReader br, int N) throws IOException {
        initData(N);

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
            recordParentNode(a, b);
        }
    }

    private static void initData(int N) {
        level = new int[N + 1];
        parent = new int[N + 1];

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
    }

    private static void recordParentNode(int a, int b) {
        parent[b] = a;
    }

    private static int findRootNode(int n) {
        return IntStream.range(1, n + 1)
                .filter(number -> parent[number] == 0)
                .findFirst()
                .getAsInt();
    }

    private static void calculateNodeLevel(int rootNode) {
        level[rootNode] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : tree.get(currentNode)) {
                if (level[nextNode] != 0) {
                    continue;
                }

                level[nextNode] = level[currentNode] + 1;
                queue.add(nextNode);
            }
        }
    }

    private static void recordCommonParentNode(int commonParentNode, StringBuilder builder) {
        builder.append(commonParentNode)
                .append('\n');
    }

    private static int findCommonParentNode(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        return dfs(x, y);
    }

    private static int dfs(int x, int y) {
        if (x == y) {
            return x;
        }

        if (level[x] > level[y]) {
            return dfs(parent[x], y);
        }
        if (level[x] < level[y]) {
            return dfs(x, parent[y]);
        }
        return dfs(parent[x], parent[y]);
    }
}

package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LCA {
    private static Map<Integer, Node> store = new HashMap<>();
    private static List<List<Integer>> tree = new ArrayList<>();
    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        initData(1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            findParentNode(a, b);
        }

        System.out.print(resultBuilder);
    }

    private static void initData(int rootNode) {
        store.put(rootNode, new Node(-1, 1));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : tree.get(currentNode)) {
                if (store.containsKey(nextNode)) {
                    continue;
                }

                Node parentNode = store.get(currentNode);
                store.put(nextNode, new Node(currentNode, parentNode.calculateChildNodeLevel()));

                queue.add(nextNode);
            }
        }
    }

    private static void findParentNode(int a, int b) {
        if (a == b) {
            resultBuilder.append(a).append('\n');
            return;
        }

        Node firstNode = store.get(a);
        Node secondNode = store.get(b);

        if (firstNode.isSameLevel(secondNode)) {
            findParentNode(firstNode.getParentNode(), secondNode.getParentNode());
            return;
        }
        if (firstNode.isHigherLevelThan(secondNode)) {
            findParentNode(firstNode.getParentNode(), b);
            return;
        }
        findParentNode(a, secondNode.getParentNode());
    }
}

class Node {
    private final int parentNode;
    private final int nodeLevel;

    public Node(int parentNode, int nodeLevel) {
        this.parentNode = parentNode;
        this.nodeLevel = nodeLevel;
    }

    public int calculateChildNodeLevel() {
        return nodeLevel + 1;
    }

    public boolean isSameLevel(Node node) {
        return node.isMatch(nodeLevel);
    }

    private boolean isMatch(int nodeLevel) {
        return this.nodeLevel == nodeLevel;
    }

    public boolean isHigherLevelThan(Node node) {
        return this.nodeLevel > node.nodeLevel;
    }

    public int getParentNode() {
        return parentNode;
    }
}
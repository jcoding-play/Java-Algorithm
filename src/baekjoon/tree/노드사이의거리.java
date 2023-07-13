package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의거리 {
    private static List<List<Edge>> graph;
    private static boolean[] isMoved;
    private static StringTokenizer stringTokenizer;
    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        initGraph(br, N);

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            isMoved = new boolean[N + 1];
            record(calculateDistanceBetween(start, end));
        }

        System.out.print(resultBuilder);
    }

    private static void initGraph(BufferedReader br, int N) throws IOException {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(a).add(new Edge(b, distance));
            graph.get(b).add(new Edge(a, distance));
        }
    }

    private static void record(int distance) {
        resultBuilder.append(distance)
                .append('\n');
    }

    private static int calculateDistanceBetween(int start, int end) {
        isMoved[start] = true;

        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int currentNode = edge.getNode();
            int currentDistance = edge.getDistance();

            for (Edge nextEdge : graph.get(currentNode)) {
                if (nextEdge.isEndNode(end)) {
                    return nextEdge.addDistance(currentDistance);
                }

                int nextNode = nextEdge.getNode();
                if (isMoved[nextNode]) {
                    continue;
                }

                isMoved[nextNode] = true;
                queue.add(new Edge(nextNode, nextEdge.addDistance(currentDistance)));
            }
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    static class Edge {
        private final int node;
        private final int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public boolean isEndNode(int node) {
            return this.node == node;
        }

        public int addDistance(int currentDistance) {
            return distance + currentDistance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }
}

package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전이진트리 {
    private static List<List<Integer>> answers = new ArrayList<>();
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            answers.add(new ArrayList<>());
        }

        int numberOfNodes = calculateNumberOfNodes();
        List<Integer> nodes = initializeNodes(br, numberOfNodes);

        recordLevelOfNodes(0, numberOfNodes - 1, nodes, 0);
        showResult();
    }

    private static int calculateNumberOfNodes() {
        return (int) (Math.pow(2, K) - 1);
    }

    private static List<Integer> initializeNodes(BufferedReader br, int numberOfNodes) throws IOException {
        List<Integer> nodes = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(Integer.parseInt(st.nextToken()));
        }

        return nodes;
    }

    private static void recordLevelOfNodes(int start, int end, List<Integer> nodes, int level) {
        if (level == K) {
            return;
        }

        int mid = (start + end) / 2;
        answers.get(level).add(nodes.get(mid));

        recordLevelOfNodes(start, mid - 1, nodes, level + 1);
        recordLevelOfNodes(mid + 1, end, nodes, level + 1);
    }

    private static void showResult() {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < K; i++) {
            for (int answer : answers.get(i)) {
                resultBuilder.append(answer).append(' ');
            }
            resultBuilder.append('\n');
        }

        System.out.print(resultBuilder);
    }
}

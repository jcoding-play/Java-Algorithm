package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프점프 {
    private static int N;
    private static int[] jumpCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        jumpCount = new int[N];
        Arrays.fill(jumpCount, Integer.MAX_VALUE);

        bfs(0, initMap(br));
        showMinimumJumpCount();
    }

    private static int[] initMap(BufferedReader br) throws IOException {
        int[] map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        return map;
    }

    private static void bfs(int index, int[] map) {
        jumpCount[index] = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(index, map[index]));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentIndex = currentNode.getIndex();
            int currentJumpNumber = currentNode.getJumpNumber();

            for (int i = 1; i <= currentJumpNumber; i++) {
                int nextIndex = currentIndex + i;
                if (isImpossibleToMove(nextIndex) || jumpCount[nextIndex] <= jumpCount[currentIndex] + 1) {
                    continue;
                }

                jumpCount[nextIndex] = jumpCount[currentIndex] + 1;
                queue.add(new Node(nextIndex, map[nextIndex]));
            }
        }
    }

    private static boolean isImpossibleToMove(int index) {
        return index >= N;
    }

    private static void showMinimumJumpCount() {
        if (jumpCount[N - 1] == Integer.MAX_VALUE) {
            jumpCount[N - 1] = -1;
        }
        System.out.println(jumpCount[N - 1]);
    }

    static class Node {
        private final int index;
        private final int jumpNumber;

        public Node(int index, int jumpNumber) {
            this.index = index;
            this.jumpNumber = jumpNumber;
        }

        public int getIndex() {
            return index;
        }

        public int getJumpNumber() {
            return jumpNumber;
        }
    }
}

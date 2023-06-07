package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = initializeQueue(N);

        List<String> list = getList(K, queue);

        String answer = String.join(", ", list);
        System.out.println("<".concat(answer).concat(">"));
    }

    private static List<String> getList(int K, Queue<Integer> queue) {
        List<String> list = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            if (++count == K) {
                count = 0;
                list.add(String.valueOf(queue.poll()));
                continue;
            }

            queue.offer(queue.poll());
        }
        return list;
    }

    private static Queue<Integer> initializeQueue(int N) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        return queue;
    }
}

package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pQ.offer(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        long sum;
        while (pQ.size() != 1) {
            sum = pQ.poll() + pQ.poll();
            pQ.offer(sum);
            answer += sum;
        }
        System.out.println(answer);
    }
}

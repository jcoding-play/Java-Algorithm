package baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pQ.add(scan.nextLong());
        }

        long answer = 0;
        while (pQ.size() >= 2) {
            long sum = pQ.poll() + pQ.poll();
            answer += sum;
            pQ.offer(sum);
        }
        System.out.println(answer);
    }
}

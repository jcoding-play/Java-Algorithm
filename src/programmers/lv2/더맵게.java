package programmers.lv2;

import java.util.PriorityQueue;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int x : scoville) {
            pQ.offer(x);
        }

        while (pQ.peek() < K) {
            if (pQ.size() == 1) {
                return -1;
            }

            int a = pQ.poll();
            int b = pQ.poll();
            pQ.offer(a + b * 2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}

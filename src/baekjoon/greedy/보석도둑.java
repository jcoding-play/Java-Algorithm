package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = getJewels(br, N);
        List<Integer> maxWeight = getMaxWeight(br, K);

        Collections.sort(jewels, Comparator.comparingInt(o -> o.M));
        Collections.sort(maxWeight);

        Long answer = 0L;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < K; i++) {
            for (; j < N; j++) {
                if (jewels.get(j).M > maxWeight.get(i)) {
                    break;
                }

                pQ.offer(jewels.get(j).V);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        System.out.println(answer);
    }

    private static List<Jewel> getJewels(BufferedReader br, int N) throws IOException {
        StringTokenizer st;
        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(M, V));
        }
        return jewels;
    }

    private static List<Integer> getMaxWeight(BufferedReader br, int K) throws IOException {
        List<Integer> maxWeight = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            maxWeight.add(Integer.parseInt(br.readLine()));
        }
        return maxWeight;
    }

    static class Jewel {
        int M;
        int V;

        public Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }
}

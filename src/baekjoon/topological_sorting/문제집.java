package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {

    static ArrayList<ArrayList<Integer>> list;
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        indeg = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            indeg[b]++;
        }

        solution(n);
        System.out.println(sb);
    }

    private static void solution(int n) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                pQ.offer(i);
            }
        }

        while (!pQ.isEmpty()) {
            int tmp = pQ.poll();
            sb.append(tmp).append(' ');

            for (int x : list.get(tmp)) {
                indeg[x]--;
                if (indeg[x] == 0) pQ.offer(x);
            }
        }
    }
}

package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {

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
            int count = Integer.parseInt(st.nextToken());
            int last = 0;

            while (count-- > 0) {
                if (last == 0) {
                    last = Integer.parseInt(st.nextToken());
                    continue;
                }

                int singer = Integer.parseInt(st.nextToken());
                list.get(last).add(singer);
                indeg[singer]++;
                last = singer;
            }
        }

        solution(n);
    }

    private static void solution(int n) {
        Queue<Integer> Q = new LinkedList<>();
        dataInit(Q, n);

        int size = 0;
        while (!Q.isEmpty()) {
            int tmp = Q.poll();
            size++;
            sb.append(tmp).append('\n');

            for (int x : list.get(tmp)) {
                indeg[x]--;
                if (indeg[x] == 0) Q.offer(x);
            }
        }

        print(size, n);
    }

    private static void dataInit(Queue<Integer> Q, int n) {
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                Q.offer(i);
            }
        }
    }

    private static void print(int size, int n) {
        if (size == n) {
            System.out.print(sb);
            return;
        }
        System.out.print("0");
    }
}

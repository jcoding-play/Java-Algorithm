package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indeg = new int[n + 1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
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
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) Q.offer(i);
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            sb.append(x).append(' ');

            for (int y : list.get(x)) {
                indeg[y]--;
                if (indeg[y] == 0) Q.add(y);
            }
        }
    }
}

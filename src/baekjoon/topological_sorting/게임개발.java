package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게임개발 {

    static ArrayList<ArrayList<Integer>> list;
    static int[] time, indeg, totalMinTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        time = new int[n + 1];
        indeg = new int[n + 1];
        totalMinTime = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;

                list.get(a).add(i);
                indeg[i]++;
            }
        }

        solution(n);
        print(n);
    }

    private static void solution(int n) {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                Q.offer(i);
                totalMinTime[i] = time[i];
            }
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : list.get(now)) {
                indeg[next]--;
                if (indeg[next] == 0) Q.offer(next);

                totalMinTime[next] = Math.max(totalMinTime[next], totalMinTime[now] + time[next]);
            }
        }
    }

    private static void print(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(totalMinTime[i]).append('\n');
        }

        System.out.print(sb);
    }
}

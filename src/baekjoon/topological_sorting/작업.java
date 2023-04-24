package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업 {

    static ArrayList<ArrayList<Integer>> list;
    static int[] indeg, time, totalMinTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        indeg = new int[n + 1];
        time = new int[n + 1];
        totalMinTime = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int previousWorkCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < previousWorkCount; j++) {
                int previousWork = Integer.parseInt(st.nextToken());
                list.get(previousWork).add(i);
                indeg[i]++;
            }
        }

        solution(n);
        System.out.println(Arrays.stream(totalMinTime).max().getAsInt());
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
}

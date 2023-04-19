package baekjoon.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACM_Craft {

    static ArrayList<ArrayList<Integer>> list;
    static int[] indeg, max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
            indeg = new int[n + 1];
            max = new int[n + 1];
            int[] D = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                indeg[b]++;
            }

            solution(n, D);

            int w = Integer.parseInt(br.readLine());
            sb.append(max[w]).append('\n');
        }
        System.out.print(sb);
    }

    private static void solution(int n, int[] D) {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                Q.offer(i);
                max[i] = D[i];
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();

            for (int y : list.get(x)) {
                indeg[y]--;
                if (indeg[y] == 0) Q.offer(y);

                max[y] = Math.max(max[x] + D[y], max[y]);
            }
        }
    }
}

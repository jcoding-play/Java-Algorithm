package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {

    static int n;
    static boolean[] ch;
    static String[] map;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        ch = new boolean[n + 1];
        map = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = br.readLine();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int count = 0;
                for (int m = 0; m < k; m++) {
                    if (map[i].charAt(m) != map[j].charAt(m)) {
                        count++;

                        if (count > 1) break;
                    }
                }
                if (count == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bfs(a, b);
    }

    private static void bfs(int a, int b) {
        ch[a] = true;
        StringBuilder s = new StringBuilder();
        s.append(a).append(' ');

        Queue<Route> Q = new LinkedList<>();
        Q.offer(new Route(a, s));
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Route tmp = Q.poll();
                int x = tmp.node;
                StringBuilder sb = tmp.sb;

                for (int ob : list.get(x)) {
                    if (ob == b) {
                        sb.append(ob);
                        System.out.println(sb);
                        return;
                    }
                    if (!ch[ob]) {
                        ch[ob] = true;
                        Q.offer(new Route(ob, new StringBuilder(sb).append(ob).append(' ')));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Route {
        int node;
        StringBuilder sb;

        public Route(int node, StringBuilder sb) {
            this.node = node;
            this.sb = sb;
        }
    }
}

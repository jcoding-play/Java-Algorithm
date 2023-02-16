package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 촌수계산 {

    static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ch = new boolean[n+1];
        for (int i = 0; i <= n; i++) relation.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        System.out.println(BFS(a, b));
    }

    private static int BFS(int a, int b) {
        ch[a] = true;
        int L = 1;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(a);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int nx : relation.get(x)) {
                    if (nx == b) return L;

                    if (ch[nx] == false) {
                        ch[nx] = true;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}

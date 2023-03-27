package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    static int n;
    static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) relation.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int result = bfs(i);

            if (min > result) {
                min = result;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int user) {
        int[] count = new int[n + 1];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(user);
        while (!Q.isEmpty()) {
            int tmp = Q.poll();

            for (int x : relation.get(tmp)) {
                if (count[x] == 0) {
                    count[x] = count[tmp] + 1;
                    Q.offer(x);
                }
            }
        }

        int result = 0;
        for (int x : count) {
            result += x;
        }
        return result;
    }
}

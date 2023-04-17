package baekjoon.DP.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {

    static int[] dy;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Thing[] things = new Thing[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            things[i] = new Thing(w, v);
        }

        dy = new int[k + 1];
        System.out.println(solution(things));
    }

    private static int solution(Thing[] things) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int w = things[i].w;
            int v = things[i].v;

            for (int j = k; j >= w; j--) {
                dy[j] = Math.max(dy[j], dy[j - w] + v);
                answer = Math.max(answer, dy[j]);
            }
        }
        return answer;
    }

    static class Thing {
        int w;
        int v;

        public Thing(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}

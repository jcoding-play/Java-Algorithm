package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int[] ch = new int[100001];
    static int[] moves = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(BFS(n, k));
    }

    private static int BFS(int s, int e) {

        int answer = 0;
        if (s == e) return answer;

        ch[s] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx;
                    if (j == 2) {
                        nx = 2 * x;
                    } else {
                        nx = x + moves[j];
                    }

                    if (nx == e) return answer + 1;
                    if (nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}

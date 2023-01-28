package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] farm = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                farm[a][b] = 1;
            }

            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (farm[x][y] == 1) {
                        farm[x][y] = 0;
                        count++;
                        BFS(x, y, M, N, farm);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int x, int y, int M, int N, int[][] farm) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && farm[nx][ny] == 1) {
                        farm[nx][ny] = 0;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

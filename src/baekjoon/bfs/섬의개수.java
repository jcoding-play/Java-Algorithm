package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {

    static int[][] map;
    static int w, h;
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            countLand(sb);
        }
        System.out.print(sb);
    }

    private static void countLand(StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    count++;
                    BFS(i, j);
                }
            }
        }
        sb.append(count + "\n");
    }

    private static void BFS(int x, int y) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]==1) {
                    map[nx][ny] = 0;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

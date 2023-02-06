package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_2 {

    static int[][][] box;
    static int m, n, h;
    static Queue<int[]> Q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[n][m][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[j][k][i] = Integer.parseInt(st.nextToken());

                    if (box[j][k][i] == 1) {
                        Q.offer(new int[]{j, k, i});
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    private static int BFS() {
        int day = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = Q.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    int nh = tmp[2] + dh[j];

                    if(checkRange(nx, ny, nh) && box[nx][ny][nh]==0) {
                        box[nx][ny][nh] = 1;
                        Q.offer(new int[]{nx, ny, nh});
                    }
                }
            }
            day++;
        }

        // 토마토가 모두 익지 못하는 상황
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if(box[i][j][k]==0) return -1;
                }
            }
        }

        return day - 1;
    }

    private static boolean checkRange(int nx, int ny, int nh) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h;
    }
}

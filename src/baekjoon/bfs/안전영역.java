package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역 {

    static int[][] map;
    static boolean[][] ch;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int max = 0;
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 0; i < max; i++) {
            int count = check_length(i);
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static int check_length(int length) {
        ch = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= length) {
                    ch[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!ch[i][j]) {
                    ch[i][j] = true;
                    count++;
                    BFS(i, j);
                }
            }
        }
        return count;
    }

    private static void BFS(int x, int y) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == false) {
                    ch[nx][ny] = true;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

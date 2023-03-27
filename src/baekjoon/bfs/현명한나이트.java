package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트 {

    static int n, m;
    static int[][] map;
    static Point knight;
    static int[][] enemies, ch;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m + 1];
        ch = new int[n + 1][n + 1];
        enemies = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        knight = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            enemies[a][b] = i;
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void bfs() {
        int L = 0;
        int count = 0;

        ch[knight.x][knight.y] = 1;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(knight);
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Point tmp = Q.poll();
                int x = tmp.x;
                int y = tmp.y;

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        if (enemies[nx][ny] != 0) {
                            int index = enemies[nx][ny];

                            answer[index] = L + 1;
                            count++;
                            if (count == m) {
                                return;
                            }
                        }
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

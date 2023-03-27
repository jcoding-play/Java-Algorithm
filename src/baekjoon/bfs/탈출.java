package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

    static int r, c;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point start, end;
    static ArrayList<Point> waters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'S') {
                    start = new Point(i, j);
                } else if (map[i][j] == 'D') {
                    end = new Point(i, j);
                } else if (map[i][j] == '*') {
                    waters.add(new Point(i, j));
                }
            }
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        int L = 0;

        Queue<Point> Q = new LinkedList<>();
        Q.offer(start);
        Queue<Point> Q_water = new LinkedList<>();
        for (Point water : waters) {
            Q_water.offer(water);
        }

        while (!Q.isEmpty()) {
            int len_water = Q_water.size();
            for (int i = 0; i < len_water; i++) {
                Point water = Q_water.poll();
                int x = water.x;
                int y = water.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (!checkBoundary(nx, ny)) continue;
                    if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        Q_water.offer(new Point(nx, ny));
                    }
                }
            }

            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point s = Q.poll();
                int x = s.x;
                int y = s.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx == end.x && ny == end.y) return L + 1;

                    if (!checkBoundary(nx, ny)) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return -1;
    }

    private static boolean checkBoundary(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < r && ny < c;
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

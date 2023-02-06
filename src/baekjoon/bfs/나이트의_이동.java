package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동 {

    static int[][] map;
    static boolean[][] ch;
    static int l;
    static Chess startPoint, endPoint;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());

            ch = new boolean[l][l];
            map = new int[l][l];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            startPoint = new Chess(a, b);

            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            endPoint = new Chess(c, d);

            sb.append(BFS()).append("\n");
        }
        System.out.print(sb);
    }

    private static int BFS() {
        if(startPoint.x == endPoint.x && startPoint.y == endPoint.y) return 0;

        int move = 0;
        ch[startPoint.x][startPoint.y] = true;
        Queue<Chess> Q = new LinkedList<>();
        Q.offer(startPoint);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Chess sPoint = Q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = sPoint.x + dx[j];
                    int ny = sPoint.y + dy[j];

                    if(nx == endPoint.x && ny == endPoint.y) return move + 1;
                    if(nx>=0 && nx<l && ny>=0 && ny<l && ch[nx][ny]==false) {
                        ch[nx][ny] = true;
                        Q.offer(new Chess(nx, ny));
                    }
                }
            }
            move++;
        }
        return move;
    }
}

class Chess {
    int x;
    int y;

    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
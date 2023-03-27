package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양 {

    static int r, c;
    static char[][] map;
    static boolean[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ch = new boolean[r][c];
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !ch[i][j]) {
                    bfs(i, j);
                }
            }
        }
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }

    private static void bfs(int x, int y) {
        ch[x][y] = true;
        int wolf = 0;
        int sheep = 0;

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            if (map[tmp[0]][tmp[1]] == 'v') {
                wolf++;
            } else if (map[tmp[0]][tmp[1]] == 'o') {
                sheep++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !ch[nx][ny] && map[nx][ny] != '#') {
                    ch[nx][ny] = true;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }

        if (sheep > wolf) {
            answer[0] += sheep;
        } else {
            answer[1] += wolf;
        }
    }
}

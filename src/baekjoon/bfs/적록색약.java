package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {

    static int n;
    static char[][] colorX, colorO;
    static int[][] ch_colorX, ch_colorO;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        colorX = new char[n][n]; //적록색약이 아닌 사람이 보는 색깔
        colorO = new char[n][n]; //적록색약인 사람이 보는 색깔
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                colorX[i][j] = str.charAt(j);
                colorO[i][j] = str.charAt(j);

                if (str.charAt(j) == 'R') {
                    colorO[i][j] = 'G';
                }
            }
        }

        ch_colorX = new int[n][n]; //적록색약이 아닌 사람
        ch_colorO = new int[n][n]; //적록색약인 사람
        for (int x : check()) {
            System.out.print(x + " ");
        }
    }

    private static int[] check() {
        int count_colorX = 0; //적록색약이 아닌 사람이 보는 구역을 카운트하기 위한 변수
        int count_colorO = 0; //적록색약인 사람이 보는 구역을 카운트하기 위한 변수
        char last;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch_colorX[i][j] == 0) {
                    ch_colorX[i][j] = 1;
                    count_colorX++;
                    last = colorX[i][j];
                    BFS(i, j, last, colorX, ch_colorX);
                }

                if (ch_colorO[i][j] == 0) {
                    ch_colorO[i][j] = 1;
                    count_colorO++;
                    last = colorO[i][j];
                    BFS(i, j, last, colorO, ch_colorO);
                }
            }
        }
        return new int[]{count_colorX, count_colorO};
    }

    private static void BFS(int x, int y, char last, char[][] color, int[][] ch) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && color[nx][ny]==last && ch[nx][ny]==0) {
                    ch[nx][ny] = 1;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

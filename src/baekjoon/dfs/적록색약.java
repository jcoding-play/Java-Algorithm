package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {

    static int n;
    static char[][] colorsX, colorsO;
    static boolean[][] ch_colorX, ch_colorO;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        colorsX = new char[n][n]; //적록색약이 아닌 사람이 보는 색깔
        colorsO = new char[n][n]; //적록색약인 사람이 보는 색깔
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                colorsX[i][j] = str.charAt(j);
                colorsO[i][j] = str.charAt(j);

                if (str.charAt(j) == 'R') {
                    colorsO[i][j] = 'G';
                }
            }
        }

        ch_colorX = new boolean[n][n]; //적록색약이 아닌 사람
        ch_colorO = new boolean[n][n]; //적록색약인 사람
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
                if (!ch_colorX[i][j]) {
                    ch_colorX[i][j] = true;
                    last = colorsX[i][j];
                    count_colorX++;
                    DFS(i, j, last, colorsX, ch_colorX);
                }
                if (!ch_colorO[i][j]) {
                    ch_colorO[i][j] = true;
                    last = colorsO[i][j];
                    count_colorO++;
                    DFS(i, j, last, colorsO, ch_colorO);
                }
            }
        }
        return new int[]{count_colorX, count_colorO};
    }

    private static void DFS(int x, int y, char last, char[][] colors, boolean[][] ch) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && colors[nx][ny]==last && ch[nx][ny]==false) {
                ch[nx][ny] = true;
                DFS(nx, ny, last, colors, ch);
            }
        }
    }
}

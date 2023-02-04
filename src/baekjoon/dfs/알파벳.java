package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    static boolean[] ch = new boolean[26]; //나온 알파벳을 체크해주기 위한 체크 배열
    static char[][] board;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                board[i][j] = str.charAt(j-1);
            }
        }

        char tmp = board[1][1];
        ch[tmp - 'A'] = true;
        DFS(1, 1, 1);
        System.out.println(answer);
    }

    private static void DFS(int x, int y, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= R && ny >= 1 && ny <= C) {
                char tmp = board[nx][ny];
                if (ch[tmp - 'A'] == false) {
                    ch[tmp - 'A'] = true;
                    DFS(nx, ny, count + 1);
                    ch[tmp - 'A'] = false;
                }
            }
        }
    }
}

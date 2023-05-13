package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기 {

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }

        int existRowCount = 0;
        for (int row = 0; row < N; row++) {
            boolean exist = false;
            for (int column = 0; column < M; column++) {
                if (map[row][column] == 'X') {
                    exist = true;
                    break;
                }
            }
            if(exist) existRowCount++;
        }
        int existColumnCount = 0;
        for (int column = 0; column < M; column++) {
            boolean exist = false;
            for (int row = 0; row < N; row++) {
                if (map[row][column] == 'X') {
                    exist = true;
                    break;
                }
            }
            if(exist) existColumnCount++;
        }

        int needRowCount = N - existRowCount;
        int needColumnCount = M - existColumnCount;

        System.out.println(Math.max(needRowCount, needColumnCount));
    }
}

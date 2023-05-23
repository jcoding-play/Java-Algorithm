package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 판화 {

    static int N;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        char[] moves = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '.';
            }
        }

        int[] currentPos = {0, 0};
        for (char move : moves) {
            move(currentPos, move);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void move(int[] currentPos, char move) {
        int x = currentPos[0];
        int y = currentPos[1];
        int nx = 0;
        int ny = 0;

        if (move == 'R') {
            nx = x + dx[0];
            ny = y + dy[0];
            if (exceedRange(nx) || exceedRange(ny)) return;
        }
        if (move == 'D') {
            nx = x + dx[1];
            ny = y + dy[1];
            if (exceedRange(nx) || exceedRange(ny)) return;
        }
        if (move == 'L') {
            nx = x + dx[2];
            ny = y + dy[2];
            if (exceedRange(nx) || exceedRange(ny)) return;
        }
        if (move == 'U') {
            nx = x + dx[3];
            ny = y + dy[3];
            if (exceedRange(nx) || exceedRange(ny)) return;
        }

        changeMap(currentPos, move);
        currentPos[0] = nx;
        currentPos[1] = ny;
        changeMap(currentPos, move);
    }

    private static void changeMap(int[] currentPos, char move) {
        int x = currentPos[0];
        int y = currentPos[1];

        if (move == 'U' || move == 'D') {
            if (map[y][x] == '.') {
                map[y][x] = '|';
            }
            if (map[y][x] == '-') {
                map[y][x] = '+';
            }
            return;
        }
        if (move == 'R' || move == 'L') {
            if (map[y][x] == '.') {
                map[y][x] = '-';
            }
            if (map[y][x] == '|') {
                map[y][x] = '+';
            }
        }
    }

    private static boolean exceedRange(int value) {
        return value < 0 || value >= N;
    }
}

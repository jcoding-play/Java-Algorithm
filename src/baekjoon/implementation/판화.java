package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 판화 {

    static int N;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final Map<Character, Integer> classifier = new HashMap<>();

    static {
        classifier.put('R', 0);
        classifier.put('D', 1);
        classifier.put('L', 2);
        classifier.put('U', 3);
    }

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
        int[] nextPos = getNextPos(currentPos, move);
        if (exceedRange(nextPos)) return;

        changeMap(currentPos, move);
        currentPos[0] = nextPos[0];
        currentPos[1] = nextPos[1];
        changeMap(currentPos, move);
    }

    private static int[] getNextPos(int[] currentPos, char move) {
        int[] nextPos = new int[2];
        int index = classifier.get(move);

        nextPos[0] = currentPos[0] + dx[index];
        nextPos[1] = currentPos[1] + dy[index];
        return nextPos;
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

    private static boolean exceedRange(int[] pos) {
        return pos[0] < 0 || pos[0] >= N || pos[1] < 0 || pos[1] >= N;
    }
}

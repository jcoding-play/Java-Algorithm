package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {

    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                getMaxCount(i, j, map);
            }
        }
        System.out.println(answer);
    }

    private static void getMaxCount(int x, int y, char[][] map) {
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (exceedRange(nx, ny)) continue;
            if (isCandyDifferent(map, x, y, nx, ny)) {
                changeCandy(map, x, y, nx, ny);
                answer = Math.max(answer, getMaxCount(map));
                changeCandy(map, nx, ny, x, y);
            }
        }
    }

    private static boolean exceedRange(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= N;
    }

    private static boolean isCandyDifferent(char[][] map, int x, int y, int nx, int ny) {
        return map[x][y] != map[nx][ny];
    }

    private static void changeCandy(char[][] map, int x, int y, int nx, int ny) {
        char tmp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = tmp;
    }

    private static int getMaxCount(char[][] map) {
        return Math.max(getMaxRowCount(map), getMaxColumnCount(map));
    }

    private static int getMaxRowCount(char[][] map) {
        int maxCount = 1;
        for (int row = 0; row < N; row++) {
            int count = 1;
            char currentCharacter = map[row][0];
            for (int col = 1; col < N; col++) {
                if (map[row][col] == currentCharacter) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                    continue;
                }
                currentCharacter = map[row][col];
                count = 1;
            }
        }
        return maxCount;
    }

    private static int getMaxColumnCount(char[][] map) {
        int maxCount = 1;
        for (int col = 0; col < N; col++) {
            int count = 1;
            char currentCharacter = map[0][col];
            for (int row = 1; row < N; row++) {
                if (map[row][col] == currentCharacter) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                    continue;
                }
                currentCharacter = map[row][col];
                count = 1;
            }
        }
        return maxCount;
    }
}

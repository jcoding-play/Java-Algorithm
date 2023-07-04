package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 누울자리를찾아라 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = initializeMap(br, N);

        findHorizontalSeat(map, N, 0);
        findVerticalSeat(map, N, 0);

        System.out.println(sb);
    }

    private static char[][] initializeMap(BufferedReader br, int N) throws IOException {
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (char) br.read();
            }
            br.read();
        }
        return map;
    }

    private static void findHorizontalSeat(char[][] map, int n, int totalCount) {
        for (int row = 0; row < n; row++) {
            int count = 0;
            for (int col = 0; col < n; col++) {
                if (map[row][col] == 'X') {
                    if (count >= 2) {
                        totalCount = totalCount + 1;
                    }
                    count = 0;
                    continue;
                }
                count++;

                if (col == n - 1 && count >= 2) {
                    totalCount = totalCount + 1;
                }
            }
        }

        sb.append(totalCount).append(' ');
    }

    private static void findVerticalSeat(char[][] map, int n, int totalCount) {
        for (int col = 0; col < n; col++) {
            int count = 0;
            for (int row = 0; row < n; row++) {
                if (map[row][col] == 'X') {
                    if (count >= 2) {
                        totalCount = totalCount + 1;
                    }
                    count = 0;
                    continue;
                }
                count++;

                if (row == n - 1 && count >= 2) {
                    totalCount = totalCount + 1;
                }
            }
        }

        sb.append(totalCount);
    }
}

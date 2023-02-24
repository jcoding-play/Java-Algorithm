package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[8][8];
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = (char) br.read();

                if (map[i][j] == 'F' && isWhite(i, j)) {
                    answer++;
                }
            }
            br.read();
        }
        System.out.println(answer);
    }

    private static boolean isWhite(int x, int y) {
        if (x % 2 == 0 && y % 2 == 0) {
            return true;
        } else if (x % 2 == 1 && y % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}

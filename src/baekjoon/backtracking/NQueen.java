package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    static int n;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        solution(0);
        System.out.println(answer);
    }

    private static void solution(int L) {
        if (L == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                if (checkPos(L, i)) {
                    map[L][i] = 1;
                    solution(L + 1);
                    map[L][i] = 0;
                }
            }
        }
    }

    private static boolean checkPos(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    if(y==j) return false;
                    if(i+j == x+y) return false;
                    if(i-j == x-y) return false;
                }
            }
        }
        return true;
    }
}

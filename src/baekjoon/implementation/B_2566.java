package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2566 {
    private static int max = Integer.MIN_VALUE;
    private static int[] maxPoint = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[10][10];

        StringTokenizer stringTokenizer;
        for (int i = 1; i <= 9; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());

            for (int j = 1; j <= 9; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                findMaxValue(board[i][j], i, j);
            }
        }

        System.out.println(max);
        System.out.println(maxPoint[0] + " " + maxPoint[1]);
    }

    private static void findMaxValue(int value, int i, int j) {
        if (value > max) {
            max = value;
            maxPoint[0] = i;
            maxPoint[1] = j;
        }
    }
}

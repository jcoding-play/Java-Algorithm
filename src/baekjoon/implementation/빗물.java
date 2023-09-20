package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int H = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());

        boolean[][] isBlock = initBlock(H, W);

        int result = calculateResult(isBlock, H, W);
        System.out.println(result);
    }

    private static boolean[][] initBlock(int H, int W) throws IOException {
        boolean[][] isBlock = new boolean[H + 1][W + 1];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int column = 1; column <= W; column++) {
            int height = Integer.parseInt(tokenizer.nextToken());

            for (int row = 0; row < height; row++) {
                isBlock[H - row][column] = true;
            }
        }
        return isBlock;
    }

    private static int calculateResult(boolean[][] isBlock, int H, int W) {
        int result = 0;

        for (int row = H; row > 0; row--) {
            result += getCount(isBlock, row, W);
        }

        return result;
    }

    private static int getCount(boolean[][] isBlock, int row, int W) {
        int totalCount = 0;

        int count = 0;
        boolean flag = false;
        for (int col = 1; col <= W; col++) {
            if (isBlock[row][col] && flag) {
                totalCount += count;
                count = 0;
                continue;
            }
            if (isBlock[row][col]) {
                flag = true;
                continue;
            }
            if (!isBlock[row][col] && flag) {
                count++;
            }
        }
        return totalCount;
    }
}

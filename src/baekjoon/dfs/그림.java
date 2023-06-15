package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그림 {
    private static final int COLORED_PART_NUMBER = 1;
    private static final int UNCOLORED_PART_NUMBER = 0;
    private static final int DEFAULT_AREA_NUMBER = 0;
    private static final int MIN_RANGE = 0;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int N;
    private static int M;
    private static int area = 0;
    private static int maxArea = 0;
    private static int numberOfPainting = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        analyze(initDrawingPaper(reader));

        System.out.print(numberOfPainting + System.lineSeparator() + maxArea);
    }

    private static int[][] initDrawingPaper(BufferedReader reader) throws IOException {
        int[][] drawingPaper = new int[N][M];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                drawingPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return drawingPaper;
    }

    private static void analyze(int[][] drawingPaper) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                countNumberOfPainting(i, j, drawingPaper);
            }
        }
    }

    private static void countNumberOfPainting(int x, int y, int[][] drawingPaper) {
        if (drawingPaper[x][y] == COLORED_PART_NUMBER) {
            numberOfPainting++;
            drawingPaper[x][y] = UNCOLORED_PART_NUMBER;
            area++;

            findMaxArea(x, y, drawingPaper);
        }
    }

    private static void findMaxArea(int x, int y, int[][] drawingPaper) {
        dfs(x, y, drawingPaper);
        maxArea = Math.max(maxArea, area);

        area = DEFAULT_AREA_NUMBER;
    }

    private static void dfs(int x, int y, int[][] drawingPaper) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isInvalid(nextX, nextY, drawingPaper)) {
                continue;
            }
            drawingPaper[nextX][nextY] = UNCOLORED_PART_NUMBER;
            area++;
            dfs(nextX, nextY, drawingPaper);
        }
    }

    private static boolean isInvalid(int x, int y, int[][] drawingPaper) {
        return isInvalidRangeOfX(x) || isInvalidRangeOfY(y) || drawingPaper[x][y] == UNCOLORED_PART_NUMBER;
    }

    private static boolean isInvalidRangeOfX(int x) {
        return x < MIN_RANGE || x >= N;
    }

    private static boolean isInvalidRangeOfY(int y) {
        return y < MIN_RANGE || y >= M;
    }
}

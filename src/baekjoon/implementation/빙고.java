package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class 빙고 {
    private static final int BOARD_SIZE = 5;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[][] board = initBoard();

        List<Point> checkedPoint = new ArrayList<>();
        int count = 0;
        boolean flag = false;
        for (int row = 0; row < BOARD_SIZE; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < BOARD_SIZE; col++) {
                int number = Integer.parseInt(st.nextToken());
                if (flag) {
                    continue;
                }
                count++;

                checkNumber(number, board, checkedPoint);
                if (isThreeBingo(checkedPoint)) {
                    flag = true;
                }
            }
        }
        System.out.println(count);
    }

    private static int[][] initBoard() throws IOException {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        return board;
    }

    private static void checkNumber(int number, int[][] board, List<Point> checkedPoint) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == number) {
                    checkedPoint.add(new Point(row, col));
                    return;
                }
            }
        }
    }

    private static boolean isThreeBingo(List<Point> checkedPoint) {
        int bingoCount = 0;

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isBingoRow(checkedPoint, row)) {
                bingoCount++;
            }
        }
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isBingoCol(checkedPoint, col)) {
                bingoCount++;
            }
        }
        if (isBingoDiagonal(checkedPoint)) {
            bingoCount++;
        }
        if (isBingoReverseDiagonal(checkedPoint)) {
            bingoCount++;
        }

        return bingoCount >= 3;
    }

    private static boolean isBingoRow(List<Point> checkedPoint, int row) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (!checkedPoint.contains(new Point(row, col))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingoCol(List<Point> checkedPoint, int col) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (!checkedPoint.contains(new Point(row, col))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingoDiagonal(List<Point> checkedPoint) {
        for (int i = 0; i < 5; i++) {
            if (!checkedPoint.contains(new Point(i, i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingoReverseDiagonal(List<Point> checkedPoint) {
        for (int i = 0; i < 5; i++) {
            if (!checkedPoint.contains(new Point(i, 4 - i))) {
                return false;
            }
        }
        return true;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

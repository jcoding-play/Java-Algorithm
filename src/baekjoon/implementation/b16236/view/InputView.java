package baekjoon.implementation.b16236.view;

import baekjoon.implementation.b16236.utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final String BOARD_DELIMITER = " ";

    private static Scanner scanner = new Scanner(System.in);

    public int inputN() {
        String input = scanner.nextLine();
        Validator.validateN(input);
        return Integer.parseInt(input);
    }

    public int[][] inputBoard(int n) {
        int[][] board = new int[n][n];

        for (int x = 0; x < n; x++) {
            record(n, board[x]);
        }
        return board;
    }

    private void record(int n, int[] board) {
        String[] input = scanner.nextLine().split(BOARD_DELIMITER);
        Validator.validateBoard(input, n);

        for (int y = 0; y < n; y++) {
            board[y] = Integer.parseInt(input[y]);
        }
    }
}

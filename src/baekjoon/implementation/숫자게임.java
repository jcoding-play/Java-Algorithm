package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 숫자게임 {
    private static final int NUMBERS_SIZE = 5;
    private static final int SELECTED_NUMBERS_SIZE = 3;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] playerMaxNumber;
    private static int[] selectedNumbers;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        playerMaxNumber = new int[N + 1];

        for (int player = 1; player <= N; player++) {
            int[] numbers = initializeNumbers(new StringTokenizer(reader.readLine()));

            selectedNumbers = new int[SELECTED_NUMBERS_SIZE];
            dfs(0, 0, numbers, player);
        }

        System.out.println(findWinner());
    }

    private static int[] initializeNumbers(StringTokenizer stringTokenizer) {
        return IntStream.range(0, NUMBERS_SIZE)
                .map(index -> Integer.parseInt(stringTokenizer.nextToken()))
                .toArray();
    }

    private static void dfs(int start, int index, int[] numbers, int player) {
        if (index == SELECTED_NUMBERS_SIZE) {
            compare(calculateSumOfDigits(), player);
            return;
        }

        for (int i = start; i < NUMBERS_SIZE; i++) {
            selectedNumbers[index] = numbers[i];
            dfs(i + 1, index + 1, numbers, player);
        }
    }

    private static int calculateSumOfDigits() {
        int sum = Arrays.stream(selectedNumbers)
                .sum();

        return sum % 10;
    }

    private static void compare(int result, int player) {
        if (playerMaxNumber[player] < result) {
            playerMaxNumber[player] = result;
        }
    }

    private static int findWinner() {
        return findWinner(findMaxNumber());
    }

    private static int findWinner(int maxNumber) {
        return IntStream.range(1, playerMaxNumber.length)
                .filter(index -> isMaxNumber(playerMaxNumber[index], maxNumber))
                .max()
                .getAsInt();
    }

    private static boolean isMaxNumber(int number, int maxNumber) {
        return number == maxNumber;
    }

    private static int findMaxNumber() {
        return Arrays.stream(playerMaxNumber)
                .max()
                .getAsInt();
    }
}

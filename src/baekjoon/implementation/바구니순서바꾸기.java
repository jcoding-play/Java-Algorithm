package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 바구니순서바꾸기 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] basket = initBasket(N);

        while (isRunning(M--)) {
            tokenizer = new StringTokenizer(reader.readLine());
            int begin = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int mid = Integer.parseInt(tokenizer.nextToken());

            changeBasketNumbers(basket, begin, end, mid);
        }

        showBasketNumbers(basket);
    }

    private static int[] initBasket(int N) {
        int[] basket = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        return basket;
    }

    private static boolean isRunning(int number) {
        return number > 0;
    }

    private static void changeBasketNumbers(int[] basket, int begin, int end, int mid) {
        List<Integer> changedNumbers = getChangedNumbers(basket, begin, end, mid);

        changeNumbers(basket, changedNumbers, begin, end);
    }

    private static List<Integer> getChangedNumbers(int[] basket, int begin, int end, int mid) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = mid; i <= end; i++) {
            numbers.add(basket[i]);
        }
        for (int i = begin; i < mid; i++) {
            numbers.add(basket[i]);
        }

        return numbers;
    }

    private static void changeNumbers(int[] basket, List<Integer> numbers, int begin, int end) {
        int indexOfNumbers = 0;

        for (int i = begin; i <= end; i++) {
            basket[i] = numbers.get(indexOfNumbers++);
        }
    }

    private static void showBasketNumbers(int[] basket) {
        Arrays.stream(basket)
                .skip(1)
                .forEach(number -> System.out.print(number + " "));
    }
}

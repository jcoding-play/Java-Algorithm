package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바구니뒤집기 {
    private static StringTokenizer tokenizer;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] basket = initBasket(N);

        makeReverseOrder(basket, M);
        showBasket(basket);
    }

    private static int[] initBasket(int N) {
        int[] basket = new int[N];

        for (int index = 0; index < N; index++) {
            basket[index] = index + 1;
        }

        return basket;
    }

    private static void makeReverseOrder(int[] basket, int M) throws IOException {
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            reverse(basket, start, end);
        }
    }

    public static void reverse(int[] basket, int start, int end) {
        int startIndex = start - 1;
        int endIndex = end - 1;

        while (startIndex < endIndex) {
            change(basket, startIndex, endIndex);

            startIndex++;
            endIndex--;
        }
    }

    protected static void change(int[] basket, int startIndex, int endIndex) {
        int tmp = basket[startIndex];
        basket[startIndex] = basket[endIndex];
        basket[endIndex] = tmp;
    }

    private static void showBasket(int[] basket) {
        Arrays.stream(basket)
                .forEach(number -> System.out.print(number + " "));
    }
}

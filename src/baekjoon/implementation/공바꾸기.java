package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공바꾸기 {
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] basket = initBasket(N);

        while (M-- > 0) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            exchangeBalls(i, j, basket);
        }

        showBallsInBasket(basket);
    }

    private static int[] initBasket(int N) {
        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }
        return basket;
    }

    private static void exchangeBalls(int i, int j, int[] basket) {
        int tmp = basket[i];
        basket[i] = basket[j];
        basket[j] = tmp;
    }

    private static void showBallsInBasket(int[] basket) {
        Arrays.stream(basket)
                .skip(1)
                .forEach(ball -> System.out.print(ball + " "));
    }
}

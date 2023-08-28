package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공넣기 {
    private static StringTokenizer stringTokenizer;
    private static int[] basket;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        basket = new int[N + 1];

        while (M-- > 0) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            putBall(i, j, k);
        }

        showBallsInBasket();
    }

    private static void putBall(int i, int j, int k) {
        for (int index = i; index <= j; index++) {
            basket[index] = k;
        }
    }

    private static void showBallsInBasket() {
        Arrays.stream(basket)
                .skip(1)
                .forEach(ball -> System.out.print(ball + " "));
    }
}

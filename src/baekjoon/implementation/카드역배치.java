package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 카드역배치 {
    private static final int CARDS_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] cards = initCards();

        changeOrders(cards);
        showCards(cards);
    }

    private static int[] initCards() {
        int[] cards = new int[CARDS_SIZE + 1];

        for (int i = 1; i <= CARDS_SIZE; i++) {
            cards[i] = i;
        }

        return cards;
    }

    private static void changeOrders(int[] cards) {
        StringTokenizer tokenizer;

        for (int i = 0; i < 10; i++) {
            tokenizer = new StringTokenizer(scanner.nextLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            changeOrder(cards, start, end);
        }
    }

    private static void changeOrder(int[] cards, int start, int end) {
        while (start < end) {
            int tmp = cards[start];
            cards[start] = cards[end];
            cards[end] = tmp;

            start++;
            end--;
        }
    }

    private static void showCards(int[] cards) {
        Arrays.stream(cards)
                .skip(1)
                .forEach(card -> System.out.print(card + " "));
    }
}

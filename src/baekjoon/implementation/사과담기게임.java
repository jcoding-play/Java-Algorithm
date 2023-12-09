package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 사과담기게임 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Basket basket = initializeBasket(new StringTokenizer(scanner.nextLine()));

        int appleCount = scanner.nextInt();
        int minMoveCount = calculateMinMoveCount(basket, appleCount);

        System.out.println(minMoveCount);
    }

    private static Basket initializeBasket(StringTokenizer tokenizer) {
        int screenSize = Integer.parseInt(tokenizer.nextToken());
        int basketSize = Integer.parseInt(tokenizer.nextToken());

        return new Basket(basketSize);
    }

    private static int calculateMinMoveCount(Basket basket, int appleCount) {
        return Stream.generate(scanner::nextInt)
                .limit(appleCount)
                .map(fallingPosition -> basket.countMinMove(fallingPosition, 0))
                .reduce(0, Integer::sum);
    }

    static class Basket {
        private final int[] basketPosition;

        public Basket(int basketSize) {
            this.basketPosition = initializeBasketPosition(basketSize);
        }

        private int[] initializeBasketPosition(int basketSize) {
            return IntStream.range(0, basketSize)
                    .map(index -> index + 1)
                    .toArray();
        }

        public int countMinMove(int fallingPosition, int movedCount) {
            if (canCatchApple(fallingPosition)) {
                return movedCount;
            }

            movePosition(fallingPosition);
            return countMinMove(fallingPosition, movedCount + 1);
        }

        private boolean canCatchApple(int fallingPosition) {
            return Arrays.stream(basketPosition)
                    .anyMatch(position -> position == fallingPosition);
        }

        private void movePosition(int fallingPosition) {
            if (isFallingLeftSide(fallingPosition)) {
                move(index -> basketPosition[index] -= 1);
                return;
            }
            move(index -> basketPosition[index] += 1);
        }

        private boolean isFallingLeftSide(int fallingPosition) {
            return fallingPosition < basketPosition[0];
        }

        private void move(Consumer<Integer> consumer) {
            IntStream.range(0, basketPosition.length)
                    .forEach(consumer::accept);
        }
    }
}

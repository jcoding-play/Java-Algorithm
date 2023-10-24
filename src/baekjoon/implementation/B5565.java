package baekjoon.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B5565 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPrice = scanner.nextInt();
        List<Integer> prices = initPrices(scanner);

        System.out.println(calculatePrice(prices, totalPrice));
    }

    private static List<Integer> initPrices(Scanner scanner) {
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            prices.add(scanner.nextInt());
        }
        return prices;
    }

    private static int calculatePrice(List<Integer> prices, int totalPrice) {
        return totalPrice - calculatePrices(prices);
    }

    private static int calculatePrices(List<Integer> prices) {
        return prices.stream()
                .reduce(0, Integer::sum);
    }
}

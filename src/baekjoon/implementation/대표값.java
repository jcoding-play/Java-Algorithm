package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class 대표값 {
    private static final int NUMBERS_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            int number = scanner.nextInt();

            sum += number;
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        System.out.println(calculateMean(sum));
        System.out.println(calculateMode(countMap));
    }

    private static int calculateMean(int sum) {
        return sum / NUMBERS_SIZE;
    }

    private static int calculateMode(Map<Integer, Integer> countMap) {
        return countMap.keySet()
                .stream()
                .sorted((o1, o2) -> countMap.get(o2) - countMap.get(o1))
                .collect(Collectors.toList())
                .get(0);
    }
}

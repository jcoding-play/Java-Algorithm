package baekjoon.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 홀수 {
    private static final int MIN_SIZE_OF_NUMBERS = 0;
    private static final int MAX_SIZE_OF_NUMBERS = 7;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> oddNumbers = findOddNumbers(initNumbers());

        if (hasNotOddNumbers(oddNumbers)) {
            System.out.println(-1);
            return;
        }

        System.out.printf("%d\n%d", calculateSumOf(oddNumbers), findMinimumNumberOf(oddNumbers));
    }

    private static List<Integer> initNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_SIZE_OF_NUMBERS; i < MAX_SIZE_OF_NUMBERS; i++) {
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    protected static List<Integer> findOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> isOddNumber(number))
                .collect(Collectors.toList());
    }

    private static boolean isOddNumber(Integer number) {
        return number % 2 == 1;
    }

    private static boolean hasNotOddNumbers(List<Integer> oddNumbers) {
        return oddNumbers.size() == 0;
    }

    protected static Integer calculateSumOf(List<Integer> oddNumbers) {
        return oddNumbers.stream()
                .reduce(0, Integer::sum);
    }

    protected static Integer findMinimumNumberOf(List<Integer> oddNumbers) {
        return oddNumbers.stream()
                .min(Integer::compareTo)
                .get();
    }
}

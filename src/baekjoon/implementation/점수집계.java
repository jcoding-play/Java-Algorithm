package baekjoon.implementation;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 점수집계 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            List<Integer> numbers = initializeNumbers(tokenizer);
            removeMaxAndMinNumber(numbers);

            Object result = calculateResult(numbers);
            resultBuilder.append(result).append(System.lineSeparator());
        }

        System.out.print(resultBuilder);
    }

    private static List<Integer> initializeNumbers(StringTokenizer tokenizer) {
        return IntStream.range(0, 5)
                .mapToObj(index -> Integer.parseInt(tokenizer.nextToken()))
                .sorted()
                .collect(Collectors.toList());
    }

    private static void removeMaxAndMinNumber(List<Integer> numbers) {
        numbers.remove(numbers.size() - 1);
        numbers.remove(0);
    }

    private static Object calculateResult(List<Integer> numbers) {
        if (isKin(numbers)) {
            return "KIN";
        }
        return sum(numbers);
    }

    private static boolean isKin(List<Integer> numbers) {
        int maxNumber = findMaxNumber(numbers);
        int minNumber = findMinNumber(numbers);

        return maxNumber - minNumber >= 4;
    }

    private static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    private static int findMinNumber(List<Integer> numbers) {
        return numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}

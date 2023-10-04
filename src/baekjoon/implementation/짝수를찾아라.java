package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 짝수를찾아라 {
    private static final int NUMBERS_SIZE = 7;
    private static final String SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            List<Integer> numbers = initNumbers(tokenizer);

            List<Integer> evenNumbers = findEvenNumbers(numbers);
            int sum = calculateSumOfEvenNumbers(evenNumbers);
            int min = findMinNumberOf(evenNumbers);

            recordResult(resultBuilder, sum, min);
        }

        System.out.print(resultBuilder);
    }

    private static List<Integer> initNumbers(StringTokenizer tokenizer) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < NUMBERS_SIZE; i++) {
            numbers.add(Integer.parseInt(tokenizer.nextToken()));
        }

        return numbers;
    }

    private static List<Integer> findEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> isEven(number))
                .collect(Collectors.toList());
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static int calculateSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static int findMinNumberOf(List<Integer> numbers) {
        return numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    private static void recordResult(StringBuilder resultBuilder, int sum, int min) {
        resultBuilder.append(sum)
                .append(SPACE)
                .append(min)
                .append(NEWLINE);
    }
}

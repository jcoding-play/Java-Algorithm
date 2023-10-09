package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class 와글와글숭고한 {
    private static Map<Integer, String> store = new HashMap<>();

    static {
        store.put(0, "Soongsil");
        store.put(1, "Korea");
        store.put(2, "Hanyang");
        store.put(3, "OK");
    }

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        List<Integer> numbers = initializeNumbers(input);

        int sum = calculateSumOfNumbers(numbers);
        int result = getResult(numbers, sum);

        showResult(result);
    }

    private static List<Integer> initializeNumbers(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int calculateSumOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static int getResult(List<Integer> numbers, int sum) {
        if (sum >= 100) {
            return 3;
        }
        return findMinNumberIndex(numbers);
    }

    private static int findMinNumberIndex(List<Integer> numbers) {
        int index = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);

            if (number < min) {
                min = number;
                index = i;
            }
        }

        return index;
    }

    private static void showResult(int result) {
        System.out.println(store.get(result));
    }
}

package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class 나무조각 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        List<Integer> numbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!isSorted(numbers)) {
            sort(numbers);
        }
    }

    private static boolean isSorted(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return numbers.equals(sortedNumbers);
    }

    private static void sort(List<Integer> numbers) {
        for (int index = 0; index < numbers.size() - 1; index++) {
            sort(numbers, index);
        }
    }

    private static void sort(List<Integer> numbers, int index) {
        int first = numbers.get(index);
        int second = numbers.get(index + 1);

        if (first > second) {
            numbers.set(index, second);
            numbers.set(index + 1, first);
            showNumbers(numbers);
        }
    }

    private static void showNumbers(List<Integer> numbers) {
        numbers.forEach(number -> System.out.print(number + " "));
        System.out.println();
    }
}

package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class ABC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = initNumbers(scanner);

        int A = findA(numbers);
        int C = findC(numbers);
        int B = findB(numbers, A, C);

        Map<Character, Integer> store = initMap(A, B, C);

        for (char letter : scanner.nextLine().toCharArray()) {
            System.out.print(store.get(letter) + " ");
        }
    }

    private static int findA(List<Integer> numbers) {
        return numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    private static int findC(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    private static int findB(List<Integer> numbers, int A, int C) {
        return numbers.stream()
                .filter(number -> number > A && number < C)
                .findFirst()
                .get();
    }

    private static List<Integer> initNumbers(Scanner scanner) {
        String[] inputs = scanner.nextLine().split(" ");

        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Map<Character, Integer> initMap(int A, int B, int C) {
        Map<Character, Integer> store = new HashMap<>();

        store.put('A', A);
        store.put('B', B);
        store.put('C', C);

        return store;
    }
}

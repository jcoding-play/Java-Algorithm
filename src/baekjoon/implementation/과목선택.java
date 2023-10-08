package baekjoon.implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 과목선택 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            numbers.add(number);

            result += number;
        }
        int minNumber = findMinNumber(numbers);
        result -= minNumber;

        numbers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int number = scanner.nextInt();
            numbers.add(number);

            result += number;
        }
        minNumber = findMinNumber(numbers);
        result -= minNumber;

        System.out.println(result);
    }

    private static int findMinNumber(List<Integer> numbers) {
        return numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
    }
}

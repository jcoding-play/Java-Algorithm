package baekjoon.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 세_수 {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = getNumbers(input);

        System.out.println(numbers.get(1));
    }

    protected static List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}

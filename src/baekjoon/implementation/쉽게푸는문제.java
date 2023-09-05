package baekjoon.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 쉽게푸는문제 {
    private static final String NUMBER_DELIMITER = " ";

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] numbers = input.split(NUMBER_DELIMITER);

        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);

        Progression progression = Progression.of(A, B);
        int result = progression.calculate();

        System.out.println(result);
    }
}

class Progression {
    private final int start;
    private final int end;

    public static Progression of(int start, int end) {
        return new Progression(start, end);
    }

    private Progression(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int calculate() {
        List<Integer> numbers = initNumbers();

        return IntStream.range(start - 1, end)
                .map(numbers::get)
                .sum();
    }

    protected List<Integer> initNumbers() {
        List<Integer> numbers = new LinkedList<>();

        for (int number = 1; number <= end; number++) {
            for (int count = 1; count <= number; count++) {
                numbers.add(number);

                if (numbers.size() == end) {
                    return numbers;
                }
            }
        }
        return numbers;
    }
}

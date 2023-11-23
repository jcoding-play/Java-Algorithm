package baekjoon.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 주사위 {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int testCase = inputView.readTestCase();

        List<Integer> result = Stream.generate(inputView::readNumbers)
                .limit(testCase)
                .map(input -> convertToIntegerList(input))
                .map(numbers -> add(numbers))
                .collect(Collectors.toList());

        System.out.println(generateResultMessage(result));
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int add(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static String generateResultMessage(List<Integer> result) {
        return IntStream.range(0, result.size())
                .mapToObj(index -> generateMessageOf(result, index))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String generateMessageOf(List<Integer> result, int index) {
        int sequence = index + 1;
        int number = result.get(index);

        return String.format("Case %d: %d", sequence, number);
    }

    static class InputView {
        private static Scanner scanner = new Scanner(System.in);

        public int readTestCase() {
            return Integer.parseInt(scanner.nextLine());
        }

        public String readNumbers() {
            return scanner.nextLine();
        }
    }
}

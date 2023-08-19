package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class 등장하지않는문자의합 {
    private static final int ASCII_CODE_OF_A = 65;
    private static final int ASCII_CODE_OF_Z = 90;
    private static final String NEWLINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();

            int totalAsciiCodeValue = calculateTotalAsciiCodeValue();
            int result = calculateMissingAsciiCodeValue(input, totalAsciiCodeValue);

            appendResult(resultBuilder, result);
        }

        System.out.print(resultBuilder);
    }

    protected static int calculateTotalAsciiCodeValue() {
        return IntStream.range(ASCII_CODE_OF_A, ASCII_CODE_OF_Z + 1)
                .sum();
    }

    private static int calculateMissingAsciiCodeValue(String input, int totalAsciiCodeValue) {
        return totalAsciiCodeValue - calculateAppearingAsciiCodeValue(input);
    }

    protected static int calculateAppearingAsciiCodeValue(String input) {
        return input.chars()
                .distinct()
                .sum();
    }

    private static void appendResult(StringBuilder resultBuilder, int result) {
        resultBuilder.append(result)
                .append(NEWLINE);
    }
}

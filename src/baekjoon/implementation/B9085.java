package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9085 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder resultBuilder = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            String input = reader.readLine();

            int result = add(input);
            recordResult(resultBuilder, result);
        }

        System.out.print(resultBuilder);
    }

    private static void recordResult(StringBuilder resultBuilder, int result) {
        resultBuilder.append(result)
                .append(System.lineSeparator());
    }

    private static int add(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}

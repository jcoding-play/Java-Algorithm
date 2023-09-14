package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기 {
    private static final String DELIMITER = " ";
    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            String[] numbers = reader.readLine().split(DELIMITER);

            int result = calculateResult(N, numbers);

            builder.append(result).append(NEW_LINE);
        }

        System.out.print(builder);
    }

    private static int calculateResult(int N, String[] numbers) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += Integer.parseInt(numbers[i]);
        }

        return result;
    }
}

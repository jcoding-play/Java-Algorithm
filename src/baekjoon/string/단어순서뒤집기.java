package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 단어순서뒤집기 {
    private static final String NEWLINE = System.lineSeparator();
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder messageBuilder = new StringBuilder();
        for (int testNumber = 1; testNumber <= N; testNumber++) {
            String input = br.readLine();
            String message = buildMessage(testNumber, input);

            appendMessage(messageBuilder, message);
        }

        System.out.print(messageBuilder);
    }

    protected static String buildMessage(int testNumber, String input) {
        List<String> words = reverse(findWords(input));

        return String.format("Case #%d: %s", testNumber, String.join(DELIMITER, words));
    }

    protected static List<String> findWords(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    protected static List<String> reverse(List<String> words) {
        Collections.reverse(words);
        return words;
    }

    private static void appendMessage(StringBuilder messageBuilder, String message) {
        messageBuilder.append(message)
                .append(NEWLINE);
    }
}

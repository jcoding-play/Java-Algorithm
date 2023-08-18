package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Strfry {
    private static final String POSSIBLE = "Possible";
    private static final String IMPOSSIBLE = "Impossible";
    private static final String NEWLINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder messageBuilder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstInput = st.nextToken();
            String secondInput = st.nextToken();

            buildMessage(messageBuilder, compare(firstInput, secondInput));
        }

        System.out.print(messageBuilder);
    }

    protected static String compare(String first, String second) {
        Map<Character, Integer> countMap = initCountMap(first);

        for (char letter : second.toCharArray()) {
            countMap.put(letter, countMap.getOrDefault(letter, 0) - 1);
        }

        if (isImpossible(countMap)) {
            return IMPOSSIBLE;
        }
        return POSSIBLE;
    }

    private static Map<Character, Integer> initCountMap(String first) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char letter : first.toCharArray()) {
            countMap.put(letter, countMap.getOrDefault(letter, 0) + 1);
        }

        return countMap;
    }

    private static boolean isImpossible(Map<Character, Integer> countMap) {
        return countMap.values()
                .stream()
                .anyMatch(number -> number != 0);
    }

    private static void buildMessage(StringBuilder messageBuilder, String result) {
        messageBuilder.append(result)
                .append(NEWLINE);
    }
}

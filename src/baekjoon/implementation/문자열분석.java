package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열분석 {
    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = reader.readLine()) != null) {
            Analyzer analyzer = new Analyzer(input);
            AnalyzeResult result = analyzer.analyze();
            appendResult(result);
        }

        System.out.print(resultBuilder);
    }

    private static void appendResult(AnalyzeResult analyzeResult) {
        Arrays.stream(analyzeResult.getResult())
                .forEach(result -> {
                    resultBuilder.append(result).append(" ");
                });

        resultBuilder.append(System.lineSeparator());
    }

    static class Analyzer {
        private final String input;

        public Analyzer(String input) {
            this.input = input;
        }

        public AnalyzeResult analyze() {
            AnalyzeResult result = new AnalyzeResult();

            for (char letter : input.toCharArray()) {
                result.record(letter);
            }

            return result;
        }
    }

    static class AnalyzeResult {
        private int[] result = new int[4];

        public void record(char letter) {
            if (Character.isLowerCase(letter)) {
                result[0]++;
                return;
            }
            if (Character.isUpperCase(letter)) {
                result[1]++;
                return;
            }
            if (Character.isDigit(letter)) {
                result[2]++;
                return;
            }
            result[3]++;
        }

        public int[] getResult() {
            return result;
        }
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 행복 {
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> scores = initScores(N, br.readLine());

        int result = calculateDifference(scores);
        System.out.println(result);
    }

    private static List<Integer> initScores(int N, String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    protected static int calculateDifference(List<Integer> scores) {
        return findMaxScore(scores) - findMinScore(scores);
    }

    protected static int findMaxScore(List<Integer> scores) {
        return scores.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    protected static int findMinScore(List<Integer> scores) {
        return scores.stream()
                .min(Comparator.naturalOrder())
                .get();
    }
}

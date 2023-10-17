package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 점수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        List<Integer> scores = initScores(N, tokenizer);
        int result = calculateTotalScore(scores);

        System.out.println(result);
    }

    private static List<Integer> initScores(int N, StringTokenizer tokenizer) {
        return Stream.generate(tokenizer::nextToken)
                .limit(N)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int calculateTotalScore(List<Integer> scores) {
        int totalScore = 0;

        int count = 0;
        for (Integer score : scores) {
            count = getCount(score, count);
            totalScore += count;
        }
        return totalScore;
    }

    private static int getCount(int score, int count) {
        if (score == 1) {
            return count + 1;
        }
        return 0;
    }
}

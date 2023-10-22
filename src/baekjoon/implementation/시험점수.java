package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class 시험점수 {
    private static final String NUMBER_DELIMITER = " ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Score> scores = initScores(scanner);

        System.out.println(findMaxScore(scores));
    }

    private static List<Score> initScores(Scanner scanner) {
        List<Score> scores = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            String input = scanner.nextLine();
            scores.add(getScore(input));
        }

        return scores;
    }

    private static Score getScore(String input) {
        return new Score(getNumbers(input));
    }

    private static List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int findMaxScore(List<Score> scores) {
        return scores.stream()
                .map(Score::calculateScore)
                .max(Comparator.naturalOrder())
                .get();
    }
}

class Score {
    private final List<Integer> numbers;

    public Score(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calculateScore() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 콘테스트 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("%d %d", calculateCollegeScore(), calculateCollegeScore());
    }

    private static int calculateCollegeScore() {
        return calculateCollegeScore(initScores());
    }

    private static int calculateCollegeScore(List<Integer> scores) {
        return scores.get(0) + scores.get(1) + scores.get(2);
    }

    private static List<Integer> initScores() {
        return Stream.generate(() -> scanner.nextInt())
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}

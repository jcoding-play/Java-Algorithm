package baekjoon.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 팀나누기 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        List<Integer> levels = initializeLevels(input);
        int result = calculateMinLevelDifference(levels);
        System.out.println(Math.abs(result));
    }

    private static List<Integer> initializeLevels(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private static int calculateMinLevelDifference(List<Integer> levels) {
        return (levels.get(0) + levels.get(3)) - (levels.get(1) + levels.get(2));
    }
}

package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class 꼬마정민 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calculateTotalSum(input));
    }

    private static Long calculateTotalSum(String input) {
        return Arrays.stream(input.split(" "))
                .map(Long::parseLong)
                .reduce(0L, Long::sum);
    }
}

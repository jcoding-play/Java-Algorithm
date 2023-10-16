package baekjoon.implementation;

import java.util.Scanner;
import java.util.function.Function;

public class 연세대학교 {

    public static void main(String[] args) {
        Function<Integer, String> function = input -> {
            if (input == 0) {
                return "YONSEI";
            }
            return "Leading the Way to the Future";
        };

        int input = new Scanner(System.in).nextInt();

        System.out.println(function.apply(input));
    }
}

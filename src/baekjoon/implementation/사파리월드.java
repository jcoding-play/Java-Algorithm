package baekjoon.implementation;

import java.util.Scanner;

public class 사파리월드 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] numbers = input.split(" ");

        Long N = Long.parseLong(numbers[0]);
        Long M = Long.parseLong(numbers[1]);

        System.out.println(Math.abs(N - M));
    }
}

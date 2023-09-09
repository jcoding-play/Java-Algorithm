package baekjoon.implementation;

import java.util.Scanner;

public class 이상한기호 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] numbers = input.split(" ");

        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);

        System.out.println(calculate(A, B));
    }

    private static long calculate(int a, int b) {
        return (long) (a + b) * (a - b);
    }
}

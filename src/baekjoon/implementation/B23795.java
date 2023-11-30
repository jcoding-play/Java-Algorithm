package baekjoon.implementation;

import java.util.Scanner;

public class B23795 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            int number = scanner.nextInt();
            if (isOver(number)) {
                break;
            }

            sum += number;
        }

        System.out.println(sum);
    }

    private static boolean isOver(int number) {
        return number == -1;
    }
}

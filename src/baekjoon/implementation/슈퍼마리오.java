package baekjoon.implementation;

import java.util.Scanner;

public class 슈퍼마리오 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int minDiffer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int score = scanner.nextInt();
            if (minDiffer < Math.abs(100 - (sum + score))) {
                break;
            }

            sum += score;
            minDiffer = Math.abs(100 - sum);
        }

        System.out.println(sum);
    }
}

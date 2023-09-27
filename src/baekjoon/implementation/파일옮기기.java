package baekjoon.implementation;

import java.util.Scanner;

public class 파일옮기기 {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(DELIMITER);
        int applesInBasketA = Integer.parseInt(input[0]);
        int orangeInBasketA = Integer.parseInt(input[1]);

        input = scanner.nextLine().split(DELIMITER);
        int applesInBasketB = Integer.parseInt(input[0]);
        int orangeInBasketB = Integer.parseInt(input[1]);

        int result = Math.min(applesInBasketA + orangeInBasketB, applesInBasketB + orangeInBasketA);
        System.out.println(result);
    }
}

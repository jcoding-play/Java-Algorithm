package baekjoon.implementation;

import java.util.Scanner;

public class 치킨두마리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = scanner.nextInt();

        showResult(A, B, C);
    }

    private static void showResult(int A, int B, int C) {
        if (canBuyChicken(A, B, C)) {
            showRemainingMoney(A, B, C);
            return;
        }
        System.out.println(A + B);
    }

    private static boolean canBuyChicken(int A, int B, int C) {
        return A + B >= C * 2;
    }

    private static void showRemainingMoney(int A, int B, int C) {
        int remainingMoney = A + B - C * 2;
        System.out.println(remainingMoney);
    }
}

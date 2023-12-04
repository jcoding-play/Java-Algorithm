package baekjoon.implementation;

import java.util.Scanner;

public class 수뒤집기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        while (T-- > 0) {
            String number = scanner.nextLine();
            String reverseNumber = generateReverseNumberFrom(number);
            int result = add(number, reverseNumber);

            showResult(result);
        }
    }

    private static String generateReverseNumberFrom(String number) {
        return new StringBuilder(number).reverse()
                .toString();
    }

    private static int add(String number, String reverseNumber) {
        return parseInt(number) + parseInt(reverseNumber);
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }

    private static void showResult(int result) {
        if (isSymmetrical(result)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static boolean isSymmetrical(int result) {
        String number = String.valueOf(result);
        String reverseNumber = generateReverseNumberFrom(number);

        return number.equals(reverseNumber);
    }
}

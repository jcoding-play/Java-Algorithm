package baekjoon.implementation;

import java.util.Scanner;

public class 자동완성 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String message = generateMessage(input);

        System.out.println(message);
    }

    private static String generateMessage(String input) {
        if (isN(input)) {
            return "Naver D2";
        }
        return "Naver Whale";
    }

    private static boolean isN(String input) {
        return input.equals("N") || input.equals("n");
    }
}

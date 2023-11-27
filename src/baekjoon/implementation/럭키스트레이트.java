package baekjoon.implementation;

import java.util.Scanner;

public class 럭키스트레이트 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int midIndex = input.length() / 2;

        int leftPart = sumPartOf(0, midIndex, input);
        int rightPart = sumPartOf(midIndex, input.length(), input);

        if (leftPart == rightPart) {
            System.out.println("LUCKY");
            return;
        }
        System.out.println("READY");
    }

    private static int sumPartOf(int start, int end, String input) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += Character.getNumericValue(input.charAt(i));
        }

        return sum;
    }
}

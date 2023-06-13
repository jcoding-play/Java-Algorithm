package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class 방번호 {
    private static int[] count = new int[10];

    public static void main(String[] args) {
        String N = new Scanner(System.in).nextLine();

        for (char c : N.toCharArray()) {
            count[c - '0']++;
        }

        int sixAndNineCount = count[6] + count[9];
        count[6] = sixAndNineCount / 2;
        count[9] = sixAndNineCount - count[6];

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        return Arrays.stream(count)
                .max()
                .getAsInt();
    }
}

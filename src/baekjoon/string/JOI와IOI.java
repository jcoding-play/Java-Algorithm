package baekjoon.string;

import java.util.Scanner;

public class JOI와IOI {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        int joi = 0;
        int ioi = 0;
        for (int i = 0; i < input.length() - 2; i++) {
            String word = input.substring(i, i + 3);

            if (word.equals("JOI")) {
                joi++;
                continue;
            }
            if (word.equals("IOI")) {
                ioi++;
            }
        }

        System.out.printf("%d\n%d", joi, ioi);
    }
}

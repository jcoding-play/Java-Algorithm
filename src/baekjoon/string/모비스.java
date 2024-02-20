package baekjoon.string;

import java.util.Arrays;
import java.util.Scanner;

public class 모비스 {
    private static final String MOBIS = "MOBIS";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String input = scanner.nextLine();

        final boolean result = canMakeMobis(input);
        final String message = generateMessage(result);

        System.out.println(message);
    }

    private static boolean canMakeMobis(final String input) {
        return Arrays.stream(MOBIS.split(""))
                .allMatch(input::contains);
    }

    private static String generateMessage(final boolean flag) {
        if (flag) {
            return "YES";
        }
        return "NO";
    }
}

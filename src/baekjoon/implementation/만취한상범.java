package baekjoon.implementation;

import java.util.Scanner;

public class 만취한상범 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            int n = scanner.nextInt();

            boolean[] isOpen = new boolean[n + 1];
            int result = calculateResult(1, n, isOpen);

            builder.append(result)
                    .append(System.lineSeparator());
        }

        System.out.print(builder);
    }

    private static int calculateResult(int round, int n, boolean[] isOpen) {
        if (round == n + 1) {
            return countOpenedDoor(isOpen, n);
        }

        for (int i = round; i <= n; i += round) {
            openOrClose(isOpen, i);
        }
        return calculateResult(round + 1, n, isOpen);
    }

    private static int countOpenedDoor(boolean[] isOpen, int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isOpen[i]) {
                count++;
            }
        }
        return count;
    }

    private static void openOrClose(boolean[] isOpen, int index) {
        if (isOpen[index]) {
            isOpen[index] = false;
            return;
        }
        isOpen[index] = true;
    }
}

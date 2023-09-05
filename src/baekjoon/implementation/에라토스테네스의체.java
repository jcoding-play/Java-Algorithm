package baekjoon.implementation;

import java.util.Scanner;

public class 에라토스테네스의체 {
    private static final String NUMBER_DELIMITER = " ";
    private static final int MIN_NUMBER = 2;

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] numbers = input.split(NUMBER_DELIMITER);

        int N = Integer.parseInt(numbers[0]);
        int K = Integer.parseInt(numbers[1]);

        int count = 0;
        boolean[] isChecked = new boolean[N + 1];
        for (int start = MIN_NUMBER; start <= N; start++) {
            for (int num = start; num <= N; num += start) {
                if (isChecked[num]) {
                    continue;
                }

                isChecked[num] = true;
                count++;
                if (count == K) {
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}

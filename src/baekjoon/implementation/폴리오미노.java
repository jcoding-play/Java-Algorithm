package baekjoon.implementation;

import java.util.Scanner;

public class 폴리오미노 {
    private static final String AAAA = "AAAA";
    private static final String BB = "BB";

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        StringBuilder result = new StringBuilder();

        try {
            reportResult(input, result);
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static void reportResult(String input, StringBuilder result) {
        int xCount = 0;
        for (char letter : input.toCharArray()) {
            if (letter == 'X') {
                xCount++;
                continue;
            }
            if (letter == '.') {
                if (xCount > 0) {
                    String word = generateWord(xCount);
                    result.append(word);
                }
                result.append(letter);
                xCount = 0;
            }
        }
        if (xCount > 0) {
            String word = generateWord(xCount);
            result.append(word);
        }
    }

    private static String generateWord(int count) {
        if (count % 2 != 0) {
            throw new IllegalArgumentException();
        }
        if (count % 4 != 0) {
            return AAAA.repeat(count / 4) + BB;
        }
        return AAAA.repeat(count / 4);
    }
}

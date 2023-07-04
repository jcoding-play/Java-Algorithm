package baekjoon.string;

import java.util.Scanner;

public class 카이사르암호 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        System.out.println(getAnswer(input));
    }

    private static StringBuilder getAnswer(String input) {
        StringBuilder answer = new StringBuilder();

        for (char letter : input.toCharArray()) {
            char tmp = (char) (letter - 3);
            if (tmp < 65 || tmp > 90) {
                tmp = (char) (tmp + 26);
            }

            answer.append(tmp);
        }
        return answer;
    }
}

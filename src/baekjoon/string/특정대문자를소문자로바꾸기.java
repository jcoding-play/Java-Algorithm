package baekjoon.string;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 특정대문자를소문자로바꾸기 {
    private static final String DELIMITER = " ";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String A = scanner.nextLine();
        List<String> letters = Arrays.stream(scanner.nextLine().split(DELIMITER))
                .collect(Collectors.toList());

        for (String letter : letters) {
            A = A.replaceAll(letter, letter.toLowerCase());
        }

        System.out.println(A);
    }
}

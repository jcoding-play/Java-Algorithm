package baekjoon.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class 유학금지 {
    private static Set<Character> store = new HashSet<>();

    static {
        initStore();
    }

    private static void initStore() {
        String input = "CAMBRIDGE";

        store = Arrays.stream(input.split(""))
                .map(letter -> letter.charAt(0))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        String answer = "";
        for (char letter : input.toCharArray()) {
            if (!store.contains(letter)) {
                answer += letter;
            }
        }

        System.out.println(answer);
    }
}

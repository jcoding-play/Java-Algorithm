package baekjoon.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연길이의이상형 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<List<Character>> store = new ArrayList<>();

    static {
        store.add(List.of('E', 'I'));
        store.add(List.of('S', 'N'));
        store.add(List.of('T', 'F'));
        store.add(List.of('J', 'P'));
    }

    public static void main(String[] args) {
        String mbti = scanner.nextLine();
        String result = findOppositeMbti(mbti);

        System.out.println(result);
    }

    private static String findOppositeMbti(String mbti) {
        StringBuilder oppositeMbtiBuilder = new StringBuilder();

        for (char letter : mbti.toCharArray()) {
            oppositeMbtiBuilder.append(findOppositeOf(letter));
        }

        return oppositeMbtiBuilder.toString();
    }

    private static char findOppositeOf(char userLetter) {
        for (List<Character> letters : store) {
            if (letters.contains(userLetter)) {
                return generateOppositeLetter(letters, userLetter);
            }
        }
        throw new IllegalArgumentException();
    }

    private static char generateOppositeLetter(List<Character> letters, char letter) {
        char firstLetter = letters.get(0);
        char secondLetter = letters.get(1);

        if (firstLetter == letter) {
            return secondLetter;
        }
        return firstLetter;
    }
}

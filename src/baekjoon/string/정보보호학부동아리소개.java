package baekjoon.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 정보보호학부동아리소개 {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Character, String> classifier = new HashMap<>();

    static {
        classifier.put('M', "MatKor");
        classifier.put('W', "WiCys");
        classifier.put('C', "CyKor");
        classifier.put('A', "AlKor");
        classifier.put('$', "$clear");
    }

    public static void main(String[] args) {
        final char firstName = scanner.nextLine().charAt(0);
        final String name = findNameBy(firstName);

        System.out.println(name);
    }

    private static String findNameBy(final char firstName) {
        return classifier.get(firstName);
    }
}

package baekjoon.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 서로다른부분문자열의개수 {
    private static Set<String> count = new HashSet<>();

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            String tmp = String.valueOf(s.charAt(i));
            count.add(tmp);

            for (int j = i + 1; j < length; j++) {
                tmp += s.charAt(j);
                count.add(tmp);
            }
        }

        System.out.println(count.size());
    }
}

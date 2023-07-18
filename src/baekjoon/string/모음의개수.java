package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 모음의개수 {
    private static Set<Character> vowels = new HashSet<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }

            int count = 0;
            for (char letter : str.toLowerCase().toCharArray()) {
                if (vowels.contains(letter)) {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}

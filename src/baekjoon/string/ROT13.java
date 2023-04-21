package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isAlphabetic(charArray[i])) {
                rot13(charArray, i);
            }
        }
        System.out.println(charArray);
    }

    private static void rot13(char[] charArray, int i) {
        if (Character.isUpperCase(charArray[i])) {
            charArray[i] += 13;
            if (charArray[i] > 90) {
                charArray[i] -= 26;
            }
            return;
        }

        charArray[i] += 13;
        if (charArray[i] > 122) {
            charArray[i] -= 26;
        }
    }
}

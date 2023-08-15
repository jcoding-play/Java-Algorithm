package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 비밀번호발음하기 {
    private static final Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private static final String END = "end";
    private static final String PREFIX = "<";
    private static final String SUFFIX = ">";
    private static final String ACCEPTABLE = "is acceptable.";
    private static final String UNACCEPTABLE = "is not acceptable.";

    private static StringBuilder messageBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String password = br.readLine();
            if (password.equals(END)) {
                break;
            }

            boolean isAcceptable = isAcceptablePassword(password);
            generateMessage(password, isAcceptable);
        }

        System.out.print(messageBuilder);
    }

    private static boolean isAcceptablePassword(String password) {
        if (isNotContainsVowel(password)) {
            return false;
        }
        if (isVowelContinuous(password) || isConsonantContinuous(password)) {
            return false;
        }
        if (isSameLetterContinuous(password)) {
            return false;
        }
        return true;
    }

    protected static boolean isNotContainsVowel(String password) {
        return Arrays.stream(vowels)
                .map(String::valueOf)
                .noneMatch(password::contains);
    }

    protected static boolean isVowelContinuous(String password) {
        int continuousVowel = 0;

        for (char letter : password.toCharArray()) {
            if (isConsonant(letter)) {
                continuousVowel = 0;
                continue;
            }

            continuousVowel++;
            if (continuousVowel >= 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isConsonant(char letter) {
        return Arrays.stream(vowels)
                .noneMatch(vowel -> vowel == letter);
    }

    protected static boolean isConsonantContinuous(String password) {
        int continuousConsonant = 0;

        for (char letter : password.toCharArray()) {
            if (isVowel(letter)) {
                continuousConsonant = 0;
                continue;
            }

            continuousConsonant++;
            if (continuousConsonant >= 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVowel(char letter) {
        return Arrays.stream(vowels)
                .anyMatch(vowel -> vowel == letter);
    }

    protected static boolean isSameLetterContinuous(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            char firstLetter = password.charAt(i);
            char secondLetter = password.charAt(i + 1);

            if (firstLetter == 'e' || firstLetter == 'o') {
                continue;
            }

            if (firstLetter == secondLetter) {
                return true;
            }
        }
        return false;
    }

    private static void generateMessage(String password, boolean isAcceptable) {
        password = convertToPasswordFormat(password);

        if (isAcceptable) {
            messageBuilder.append(String.format("%s %s\n", password, ACCEPTABLE));
            return;
        }
        messageBuilder.append(String.format("%s %s\n", password, UNACCEPTABLE));
    }

    private static String convertToPasswordFormat(String password) {
        return PREFIX + password + SUFFIX;
    }
}

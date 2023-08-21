package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 애너그램 {
    private static final String NEWLINE = System.lineSeparator();
    private static final String ANAGRAM_FORMAT = "%s & %s are anagrams.";
    private static final String NOT_ANAGRAM_FORMAT = "%s & %s are NOT anagrams.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder messageBuilder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            buildMessage(messageBuilder, Anagram.of(firstWord, secondWord));
        }

        System.out.print(messageBuilder);
    }

    private static void buildMessage(StringBuilder messageBuilder, Anagram anagram) {
        messageBuilder.append(generateMessageOf(anagram))
                .append(NEWLINE);
    }

    protected static String generateMessageOf(Anagram anagram) {
        if (anagram.isAnagram()) {
            return getFormat(ANAGRAM_FORMAT, anagram);
        }
        return getFormat(NOT_ANAGRAM_FORMAT, anagram);
    }

    private static String getFormat(String anagramFormat, Anagram anagram) {
        return String.format(anagramFormat, anagram.getFirstWord(), anagram.getSecondWord());
    }
}

class Anagram {
    private final String firstWord;
    private final String secondWord;

    private Anagram(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public static Anagram of(String firstWord, String secondWord) {
        return new Anagram(firstWord, secondWord);
    }

    public boolean isAnagram() {
        return checkAnagram(initMap());
    }

    private Map<Character, Integer> initMap() {
        Map<Character, Integer> count = new HashMap<>();

        for (char letter : firstWord.toCharArray()) {
            count.put(letter, count.getOrDefault(letter, 0) + 1);
        }

        return count;
    }

    private boolean checkAnagram(Map<Character, Integer> count) {
        for (char letter : secondWord.toCharArray()) {
            if (!count.containsKey(letter)) {
                return false;
            }

            count.put(letter, count.get(letter) - 1);
            if (count.get(letter) == 0) {
                count.remove(letter);
            }
        }

        return hasOnlyZeroValues(count);
    }

    private boolean hasOnlyZeroValues(Map<Character, Integer> count) {
        return count.values()
                .stream()
                .allMatch(value -> value == 0);
    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }
}
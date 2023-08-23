package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 비슷한단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        WordAnalyzer analyzer = new WordAnalyzer(br.readLine());
        int count = 0;
        for (int i = 1; i < N; i++) {
            String input = br.readLine();

            if (analyzer.isSimilarWord(input)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

class WordAnalyzer {
    private final Map<Character, Integer> analysis;

    public WordAnalyzer(String word) {
        this.analysis = analyze(word);
    }

    protected Map<Character, Integer> analyze(String word) {
        Map<Character, Integer> analysis = new HashMap<>();

        for (char letter : word.toCharArray()) {
            analysis.put(letter, analysis.getOrDefault(letter, 0) + 1);
        }

        return analysis;
    }

    public boolean isSimilarWord(String word) {
        Map<Character, Integer> analysis = new HashMap<>(this.analysis);

        int count = 0;
        for (char character : word.toCharArray()) {
            if (analysis.containsKey(character) && analysis.get(character) > 0) {
                count++;
                analysis.put(character, analysis.get(character) - 1);
            }
        }

        return classifyResult(word, analysis, count);
    }

    private static boolean classifyResult(String word, Map<Character, Integer> analysis, int count) {
        if (analysis.size() == word.length()) {
            if (analysis.size() == count || analysis.size() - 1 == count) {
                return true;
            }
        }
        if (analysis.size() == word.length() - 1 && word.length() - 1 == count) {
            return true;
        }
        if (analysis.size() == word.length() + 1 && word.length() == count) {
            return true;
        }

        return false;
    }

}
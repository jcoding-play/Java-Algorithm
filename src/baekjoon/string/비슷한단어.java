package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    private final String word;
    private final int[] count;

    public WordAnalyzer(String word) {
        this.word = word;
        this.count = analyze(word);
    }

    protected int[] analyze(String word) {
        int[] count = new int[26];

        for (char letter : word.toCharArray()) {
            count[letter - 'A']++;
        }

        return count;
    }

    public boolean isSimilarWord(String word) {
        int[] count = this.count.clone();

        int cnt = 0;
        for (char letter : word.toCharArray()) {
            if (count[letter - 'A'] > 0) {
                cnt++;
                count[letter - 'A']--;
            }
        }

        return classifyResult(word, cnt);
    }

    private boolean classifyResult(String word, int cnt) {
        if (this.word.length() == word.length() && (this.word.length() == cnt || this.word.length() - 1 == cnt)) {
            return true;
        }
        if (this.word.length() == word.length() - 1 && word.length() - 1 == cnt) {
            return true;
        }
        if (this.word.length() == word.length() + 1 && word.length() == cnt) {
            return true;
        }
        return false;
    }
}
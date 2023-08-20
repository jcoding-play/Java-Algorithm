package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 영단어암기는괴로워 {
    private static final String NEWLINE = System.lineSeparator();
    private static WordRepository wordRepository = new WordRepository();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }
            wordRepository.save(word);
        }

        List<String> words = wordRepository.findWords();
        System.out.println(String.join(NEWLINE, words));
    }
}

class WordRepository {
    private static Map<String, Integer> store = new HashMap<>();

    public void save(String word) {
        store.put(word, store.getOrDefault(word, 0) + 1);
    }

    protected boolean isSaved(String word) {
        return store.containsKey(word);
    }

    public List<String> findWords() {
        return store.keySet()
                .stream()
                .sorted(getWordsComparator())
                .collect(Collectors.toList());
    }

    private static Comparator<String> getWordsComparator() {
        return (firstWord, secondWord) -> {
            int firstValue = store.get(firstWord);
            int secondValue = store.get(secondWord);

            if (firstValue == secondValue && firstWord.length() == secondWord.length()) {
                return firstWord.compareTo(secondWord);
            }
            if (firstValue == secondValue) {
                return secondWord.length() - firstWord.length();
            }
            return secondValue - firstValue;
        };
    }

    public void clearStore() {
        store.clear();
    }
}
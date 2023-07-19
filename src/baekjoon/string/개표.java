package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 개표 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> count = new HashMap<>();
        int V = Integer.parseInt(br.readLine());

        for (int i = 0; i < V; i++) {
            char letter = (char) br.read();
            count.put(letter, count.getOrDefault(letter, 0) + 1);
        }

        int maxCount = calculateMaxCount(count);

        showResult(count, maxCount);
    }

    private static int calculateMaxCount(Map<Character, Integer> count) {
        return count.values()
                .stream()
                .max(Integer::compareTo)
                .get();
    }

    private static void showResult(Map<Character, Integer> count, int maxCount) {
        if (isTie(count, maxCount)) {
            System.out.println("Tie");
            return;
        }

        Character winner = findWinner(count, maxCount);
        System.out.println(winner);
    }

    private static boolean isTie(Map<Character, Integer> count, int maxCount) {
        int result = (int) count.keySet()
                .stream()
                .filter(letter -> isMaxCount(count.get(letter), maxCount))
                .count();

        return result == 2;
    }

    private static Character findWinner(Map<Character, Integer> count, int maxCount) {
        return count.keySet()
                .stream()
                .filter(letter -> isMaxCount(count.get(letter), maxCount))
                .findFirst()
                .get();
    }

    private static boolean isMaxCount(int count, int maxCount) {
        return count == maxCount;
    }
}

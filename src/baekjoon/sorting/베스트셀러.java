package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class 베스트셀러 {
    private static Map<String, Integer> countMap = new TreeMap<>(Comparator.naturalOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String bookTitle = br.readLine();

            countMap.put(bookTitle, countMap.getOrDefault(bookTitle, 0) + 1);
        }

        int maxCount = 0;
        String answer = "";
        for (String booTitle : countMap.keySet()) {
            int value = countMap.get(booTitle);
            if (value > maxCount) {
                maxCount = value;
                answer = booTitle;
            }
        }
        System.out.println(answer);
    }
}

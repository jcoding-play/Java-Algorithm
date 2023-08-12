package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 알파벳거리 {
    private static final String DELIMITER = " ";
    private static final String DISTANCES_FORMAT = "%s %s\n";
    private static final String DISTANCES_PREFIX = "Distances:";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            String[] words = input.split(DELIMITER);
            List<String> distances = compareDistances(words);

            resultBuilder.append(generateMessage(distances));
        }

        System.out.println(resultBuilder);
    }

    private static List<String> compareDistances(String[] words) {
        List<String> distances = new ArrayList<>();

        for (int i = 0; i < words[0].length(); i++) {
            distances.add(calculateDistance(words, i));
        }

        return distances;
    }

    private static String calculateDistance(String[] words, int index) {
        int distance = words[1].charAt(index) - words[0].charAt(index);

        if (distance < 0) {
            return String.valueOf(distance + 26);
        }
        return String.valueOf(distance);
    }

    private static String generateMessage(List<String> distances) {
        return String.format(DISTANCES_FORMAT, DISTANCES_PREFIX, String.join(DELIMITER, distances));
    }
}

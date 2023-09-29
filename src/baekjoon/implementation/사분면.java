package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class 사분면 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<QuadrantStatus, Integer> countMap = initCountMap(reader, n);
        List<QuadrantStatus> quadrantStatuses = getQuadrantStatuses();

        showResult(countMap, quadrantStatuses);
    }

    private static Map<QuadrantStatus, Integer> initCountMap(BufferedReader reader, int n) throws IOException {
        Map<QuadrantStatus, Integer> countMap = new EnumMap<>(QuadrantStatus.class);

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            QuadrantStatus status = QuadrantStatus.of(x, y);
            countMap.put(status, countMap.getOrDefault(status, 0) + 1);
        }

        return countMap;
    }

    private static List<QuadrantStatus> getQuadrantStatuses() {
        return List.of(
                QuadrantStatus.Q1,
                QuadrantStatus.Q2,
                QuadrantStatus.Q3,
                QuadrantStatus.Q4,
                QuadrantStatus.AXIS
        );
    }

    private static void showResult(Map<QuadrantStatus, Integer> countMap, List<QuadrantStatus> quadrantStatuses) {
        quadrantStatuses.forEach(quadrantStatus -> {
            System.out.printf("%s: %d\n", quadrantStatus.name(), countMap.getOrDefault(quadrantStatus, 0));
        });
    }
}

enum QuadrantStatus {
    Q1, Q2, Q3, Q4, AXIS;

    public static QuadrantStatus of(int x, int y) {
        if (x > 0 && y > 0) {
            return Q1;
        }
        if (x > 0 && y < 0) {
            return Q4;
        }
        if (x < 0 && y > 0) {
            return Q2;
        }
        if (x < 0 && y < 0) {
            return Q3;
        }
        return AXIS;
    }
}
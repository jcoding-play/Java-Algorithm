package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 뉴스클러스터링 {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> mapOfStr1 = new HashMap<>();
        Map<String, Integer> mapOfStr2 = new HashMap<>();

        mapString(str1, mapOfStr1);
        mapString(str2, mapOfStr2);

        int unionCount = 0;
        int intersectionCount = 0;
        for (String key : mapOfStr1.keySet()) {
            if (mapOfStr2.containsKey(key)) {
                unionCount += Math.max(mapOfStr1.get(key), mapOfStr2.get(key));
                intersectionCount += Math.min(mapOfStr1.get(key), mapOfStr2.get(key));
                continue;
            }

            unionCount += mapOfStr1.get(key);
        }

        for (String key : mapOfStr2.keySet()) {
            if (!mapOfStr1.containsKey(key)) {
                unionCount += mapOfStr2.get(key);
            }
        }

        if (unionCount == 0) {
            return 65536;
        }
        double result = (double) intersectionCount / unionCount;
        return (int) (result * 65536);
    }

    private static void mapString(String str, Map<String, Integer> mapOfStr) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                String tmp = str.substring(i, i + 2);
                mapOfStr.put(tmp, mapOfStr.getOrDefault(tmp, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(solution(str1, str2));
    }
}

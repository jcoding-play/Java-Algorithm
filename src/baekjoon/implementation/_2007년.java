package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2007년 {

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> dateMap = new HashMap<>();
        Map<Integer, String> dayMap = new HashMap<>();

        initDateMap(dateMap);
        initDayMap(dayMap);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int dateSum = y;
        for (int i = 1; i < x; i++) {
            dateSum += dateMap.get(i);
        }

        System.out.println(dayMap.get(dateSum % 7));
    }

    private static void initDayMap(Map<Integer, String> dayMap) {
        dayMap.put(1, "MON");
        dayMap.put(2, "TUE");
        dayMap.put(3, "WED");
        dayMap.put(4, "THU");
        dayMap.put(5, "FRI");
        dayMap.put(6, "SAT");
        dayMap.put(0, "SUN");
    }

    private static void initDateMap(Map<Integer, Integer> dateMap) {
        dateMap.put(1, 31);
        dateMap.put(2, 28);
        dateMap.put(3, 31);
        dateMap.put(4, 30);
        dateMap.put(5, 31);
        dateMap.put(6, 30);
        dateMap.put(7, 31);
        dateMap.put(8, 31);
        dateMap.put(9, 30);
        dateMap.put(10, 31);
        dateMap.put(11, 30);
        dateMap.put(12, 31);
    }
}

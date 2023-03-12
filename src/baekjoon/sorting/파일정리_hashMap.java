package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HashMap을 이용한 풀이
 */
public class 파일정리_hashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int index = str.lastIndexOf(".");

            str = str.substring(index + 1);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((String::compareTo));

        StringBuilder sb = new StringBuilder();
        list.forEach(key -> sb.append(key).append(' ').append(map.get(key)).append('\n'));
        System.out.print(sb);
    }
}

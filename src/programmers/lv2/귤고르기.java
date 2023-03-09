package programmers.lv2;

import java.util.*;

public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (o1, o2) -> {
            return o2 - o1;
        });

        for (int x : list) {
            answer++;
            k = k - x;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(solution(k, tangerine));
    }
}

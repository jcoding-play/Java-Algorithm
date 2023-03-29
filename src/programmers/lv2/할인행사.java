package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> resultMap = new HashMap<>();
        int lt = 0;
        for (int i = 0; i < discount.length; i++) {
            if (i < 9) {
                resultMap.put(discount[i], resultMap.getOrDefault(discount[i], 0) + 1);
                continue;
            }

            resultMap.put(discount[i], resultMap.getOrDefault(discount[i], 0) + 1);
            if (wantMap.equals(resultMap)) answer++;
            resultMap.put(discount[lt], resultMap.get(discount[lt]) - 1);
            if (resultMap.get(discount[lt]) == 0) {
                resultMap.remove(discount[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
}

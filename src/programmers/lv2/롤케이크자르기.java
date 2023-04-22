package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public static int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> cheolsuTopping = new HashMap<>();
        Map<Integer, Integer> brotherTopping = new HashMap<>();
        for (int top : topping) {
            cheolsuTopping.put(top, cheolsuTopping.getOrDefault(top, 0) + 1);
        }

        for (int top : topping) {
            cheolsuTopping.put(top, cheolsuTopping.get(top) - 1);
            if (cheolsuTopping.get(top) == 0) {
                cheolsuTopping.remove(top);
            }
            brotherTopping.put(top, brotherTopping.getOrDefault(top, 0) + 1);

            if (cheolsuTopping.size() == brotherTopping.size()) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        System.out.println(solution(topping));
    }
}

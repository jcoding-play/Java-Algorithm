package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 튜플 {
    public static int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2).replace("},{", ",");
        Map<Integer, Integer> map = new HashMap<>();
        String[] str = s.split(",");
        for (String s1 : str) {
            int tmp = Integer.parseInt(s1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        for (int x : solution(s)) {
            System.out.print(x + " ");
        }
    }
}

package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill_trees.length;

        while (len-- > 0) {
            boolean flag = true;
            String tmp = skill_trees[len];

            Map<Character, Integer> map = new HashMap<>();
            int order = 1;
            for (char c : tmp.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    map.put(c, order++);
                }
            }

            int validateOrder = 0;
            for (char c : skill.toCharArray()) {
                if (!map.containsKey(c)) {
                    validateOrder = Integer.MAX_VALUE;
                    continue;
                }

                int value = map.get(c);
                if (value < validateOrder) {
                    flag = false;
                    break;
                }
                validateOrder = value;
            }
            if (flag) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}

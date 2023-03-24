package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int index = 1;
        char tmp = 'A';
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(tmp++), index++);
        }

        while (msg.length() > 0) {
            for (int j = msg.length() - 1; j >= 0; j--) {
                String str = msg.substring(0, j + 1);

                if (map.containsKey(str)) {
                    answer.add(map.get(str));

                    if (msg.length() - 1 >= j + 1) {
                        str += msg.charAt(j + 1);
                        map.put(str, index++);
                        msg = msg.substring(j + 1);
                    } else {
                        msg = "";
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        for (int x : solution(msg)) {
            System.out.print(x + " ");
        }
    }
}

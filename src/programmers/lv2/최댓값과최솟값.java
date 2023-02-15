package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    public static String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        answer = list.get(0) + " " + list.get(list.size() - 1);
        return answer;
    }

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
}

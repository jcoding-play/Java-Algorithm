package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public static String[] solution(String[] record) {
        final String in = "님이 들어왔습니다.";
        final String out = "님이 나갔습니다.";

        Map<String, String> map = new HashMap<>();
        List<String> stringList = new ArrayList<>();

        for (String tmp : record) {
            String[] s = tmp.split(" ");

            if (s[0].equals("Enter")) {
                map.put(s[1], s[2]);
                stringList.add(s[1] + " in");
            } else if (s[0].equals("Change")) {
                map.replace(s[1], s[2]);
            } else if (s[0].equals("Leave")) {
                stringList.add(s[1] + " out");
            }
        }

        String[] answer = new String[stringList.size()];
        int index = 0;
        for (String list : stringList) {
            String[] s = list.split(" ");

            String value = map.get(s[0]);
            if (s[1].equals("in")) {
                answer[index++] = value + in;
            } else {
                answer[index++] = value + out;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        for (String tmp : solution(record)) {
            System.out.println(tmp);
        }
    }
}

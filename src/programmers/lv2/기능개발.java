package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i != progresses.length) {
            addSpeeds(progresses, speeds);

            int count = 0;
            for (; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    count++;
                    continue;
                }
                break;
            }
            if (count > 0) {
                answer.add(count);
            }
        }
        return answer;
    }

    private static void addSpeeds(int[] progresses, int[] speeds) {
        for (int i = 0; i < speeds.length; i++) {
            progresses[i] += speeds[i];
        }
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        for (int x : solution(progresses, speeds)) {
            System.out.print(x + " ");
        }
    }
}

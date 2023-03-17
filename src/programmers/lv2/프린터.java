package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> Q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Q.offer(new Document(i, priorities[i]));
        }

        while (true) {
            Document tmp = Q.poll();

            boolean flag = true;
            for (Document document : Q) {
                if (tmp.priority < document.priority) {
                    Q.offer(tmp);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
                if (tmp.index == location) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

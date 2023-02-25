package programmers.lv2;

import java.util.Arrays;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length - 1;
        while (lt < rt) {
            if (people[lt] + people[rt] <= limit) {
                lt++;
            }
            rt--;
            answer++;
        }
        if (lt == rt) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}

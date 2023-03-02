package programmers.lv2;

import java.util.Arrays;

public class H_index {
    public static int solution(int[] citations) {
        int answer = 0;

        int h;
        int len = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            h = len - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {0,0,0,10};
        System.out.println(solution(citations));
    }
}

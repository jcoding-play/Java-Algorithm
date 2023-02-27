package programmers.lv2;

import java.util.Arrays;

public class N개의최소공배수 {
    public static int solution(int[] arr) {
        int answer = 0;
        int n = arr.length - 1;
        Arrays.sort(arr);
        int max = arr[n];
        int p = 1;
        while (true) {
            int numMax = max * p++;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (numMax % arr[i] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer = numMax;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }
}

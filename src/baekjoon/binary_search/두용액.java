package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int x : solution(arr)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int[] arr) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = arr.length - 1;
        int result = Integer.MAX_VALUE;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if (sum > 0) {
                rt--;
            } else if (sum < 0) {
                lt++;
            } else {
                break;
            }
        }
        return answer;
    }
}

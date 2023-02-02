package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE; //0에 가장 가까운 특성값을 저장
        int lt = 0;
        int rt = n - 1;
        int sum;
        while (lt < rt) {
            sum = arr[lt] + arr[rt];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if (sum >= 0) rt--;
            else lt++;
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}

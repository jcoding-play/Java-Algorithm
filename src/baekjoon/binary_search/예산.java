package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int answer = 0;
        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (checkBudget(mid, arr) <= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int checkBudget(int money, int[] arr) {
        int sum = 0;
        for (int x : arr) {
            if (x > money) {
                sum += money;
            } else {
                sum += x;
            }
        }
        return sum;
    }
}

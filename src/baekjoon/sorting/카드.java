package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        int count = 1;
        int maxCount = 1;
        long answer = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                    answer = arr[i];
                }
            } else {
                count = 1;
            }
        }
        System.out.println(answer);
    }
}

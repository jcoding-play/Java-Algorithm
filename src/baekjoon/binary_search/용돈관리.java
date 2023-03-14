package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(binarySearch(arr, m));
    }

    private static int binarySearch(int[] money, int m) {
        int answer = 0;

        int lt = Arrays.stream(money).max().getAsInt();
        int rt = Arrays.stream(money).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(money, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int count(int[] money, int value) {
        int count = 1;
        int sum = 0;
        for (int x : money) {
            if (sum + x > value) {
                count++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return count;
    }
}

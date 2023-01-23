package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch(arr, n));
    }

    private static long binarySearch(int[] arr, int n) {
        long answer = 0;
        long lt = 1;
        long rt = Arrays.stream(arr).max().getAsInt();
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (count(mid, arr) >= n) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static long count(long length, int[] arr) {
        long sum = 0;
        for (int x : arr) {
            sum += x / length;
        }
        return sum;
    }
}

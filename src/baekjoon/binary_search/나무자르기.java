package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(trees, m));
    }

    private static long binarySearch(int[] trees, int length) {
        long lt = 1;
        long rt = Arrays.stream(trees).max().getAsInt();
        long answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (count(mid, trees) >= length) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static long count(long height, int[] trees) {
        long sum = 0;
        for (int tree : trees) {
            if (tree - height > 0) {
                sum += (tree - height);
            }
        }
        return sum;
    }
}

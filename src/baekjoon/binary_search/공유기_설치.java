package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        System.out.println(binarySearch(house, c));
    }

    private static int binarySearch(int[] house, int c) {
        int answer = 0;
        int lt = 1;
        int rt = house[house.length - 1] - house[0];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, house) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static int count(int distance, int[] house) {
        int count = 1;
        int end = house[0];
        for (int i = 1; i < house.length; i++) {
            if (house[i] - end >= distance) {
                count++;
                end = house[i];
            }
        }
        return count;
    }
}

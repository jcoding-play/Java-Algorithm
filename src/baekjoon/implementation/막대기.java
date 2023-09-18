package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] sticks = initSticks(reader, N);

        int count = calculateCount(N, sticks);
        System.out.println(count);
    }

    private static int[] initSticks(BufferedReader reader, int N) throws IOException {
        int[] sticks = new int[N];

        for (int i = 0; i < N; i++) {
            sticks[i] = Integer.parseInt(reader.readLine());
        }

        return sticks;
    }

    private static int calculateCount(int N, int[] sticks) {
        int count = 0;
        int maxHeight = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (sticks[i] > maxHeight) {
                maxHeight = sticks[i];
                count++;
            }
        }

        return count;
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피시방알바 {
    private static final int NUMBER_OF_COMPUTERS = 100;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean[] isChecked = new boolean[NUMBER_OF_COMPUTERS + 1];

        int N = Integer.parseInt(reader.readLine());

        int count = calculateCount(N, isChecked);
        System.out.println(count);
    }

    private static int calculateCount(int N, boolean[] isChecked) throws IOException {
        int count = 0;

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (isChecked[number]) {
                count++;
                continue;
            }
            isChecked[number] = true;
        }

        return count;
    }
}

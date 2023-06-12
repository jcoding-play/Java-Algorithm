package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int maxCount = 0;
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > max) {
                max = num;
                maxCount = i;
            }
        }
        System.out.printf("%d\n%d", max, maxCount);
    }
}

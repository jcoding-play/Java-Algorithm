package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단 {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final String FORMAT = "%d * %d = %d%n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printMultiplicationTable(n);
    }

    private static void printMultiplicationTable(int n) {
        for (int num = MIN_NUMBER; num <= MAX_NUMBER; num++) {
            System.out.printf(FORMAT, n, num, n * num);
        }
    }
}

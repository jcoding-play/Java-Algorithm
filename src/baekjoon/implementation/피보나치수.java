package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수 {
    private static int[] fibo = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(calculateFibo(N));
    }

    private static int calculateFibo(int n) {
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        if (fibo[n] != 0) {
            return fibo[n];
        }
        return fibo[n] = calculateFibo(n - 1) + calculateFibo(n - 2);
    }
}

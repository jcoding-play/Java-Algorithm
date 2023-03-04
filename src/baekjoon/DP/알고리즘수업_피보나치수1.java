package baekjoon.DP;

import java.util.Scanner;

public class 알고리즘수업_피보나치수1 {

    static int count = 0;
    static int[] f;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        fibo(n);
        System.out.print(count + " ");
        count = 0;
        fibonacci(n);
        System.out.print(count);
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    private static int fibonacci(int n) {
        f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            count++;
            f[3] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}

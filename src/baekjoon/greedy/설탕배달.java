package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

    static int answer = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        calculate(n, 0);
        if (answer == 0) answer = -1;

        System.out.println(answer);
    }

    private static void calculate(int n, int count) {
        if(flag) return;

        if (n == 0) {
            flag = true;
            answer = count;
        } else if (n < 0) {
            return;
        } else {
            calculate(n - 5, count + 1);
            calculate(n - 3, count + 1);
        }
    }
}

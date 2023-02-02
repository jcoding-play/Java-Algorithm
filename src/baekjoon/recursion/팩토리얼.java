package baekjoon.recursion;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if(n<=1) return 1;
        return n * solution(n - 1);
    }
}

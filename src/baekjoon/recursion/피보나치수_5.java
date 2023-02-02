package baekjoon.recursion;

import java.util.Scanner;

public class 피보나치수_5 {

    static int[] memory;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        memory = new int[n+1];
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if(memory[n]!=0) return memory[n];

        if(n==0 || n==1) return memory[n]=n;
        else return memory[n]=solution(n-2)+solution(n-1);
    }
}

package baekjoon.implementation;

import java.util.Scanner;

public class HelloJudge {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Hello World, Judge " + i + "!");
        }
    }
}

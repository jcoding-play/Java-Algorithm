package baekjoon.implementation;

import java.util.Scanner;

public class CASIO {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] numbers = input.split(" ");

        String N = numbers[0];
        String M = numbers[1];

        if (N.equals(M)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}

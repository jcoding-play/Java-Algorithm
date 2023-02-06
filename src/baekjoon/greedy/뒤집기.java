package baekjoon.greedy;

import java.util.Scanner;

public class 뒤집기 {

    static int zeroCount;
    static int oneCount;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        zeroCount = 0;
        oneCount = 0;
        char last = str.charAt(0);
        if (last == '0') zeroCount++;
        else oneCount++;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != last) {
                last = str.charAt(i);
                countNumber(last);
            }
        }
        System.out.println(Math.min(zeroCount, oneCount));
    }

    private static void countNumber(char tmp) {
        if (tmp == '0') zeroCount++;
        else oneCount++;
    }
}

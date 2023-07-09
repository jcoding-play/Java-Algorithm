package baekjoon.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 뒤집힌덧셈 {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int answer = Rev(Rev(X) + Rev(Y));
        System.out.println(answer);
    }

    private static int Rev(int value) {
        String number = new StringBuilder(String.valueOf(value))
                .reverse()
                .toString();

        return Integer.parseInt(number);
    }
}

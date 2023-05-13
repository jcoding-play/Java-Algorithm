package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_1 {
    public static final String NEWLINE = System.lineSeparator();
    public static final char STAR = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int count = 1; count <= n; count++) {
            printStars(count, sb);
            sb.append(NEWLINE);
        }
        System.out.println(sb);
    }

    private static void printStars(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(STAR);
        }
    }
}

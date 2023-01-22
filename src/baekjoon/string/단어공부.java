package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        int[] check = new int[26];

        char answer = ' ';
        int max = 0;
        for (char c : str.toCharArray()) {
            int x = ++check[c - 'A'];
            if (max < x) {
                answer = c;
                max = x;
            } else if (max == x) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}

package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아_알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = str.length();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (str.charAt(i - 1) == 'c' || str.charAt(i - 1) == 'd') {
                    answer--;
                }
            } else if (str.charAt(i) == 'j') {
                if (str.charAt(i - 1) == 'l' || str.charAt(i - 1) == 'n') {
                    answer--;
                }
            } else if (str.charAt(i) == '=') {
                if (i - 2 >= 0 && str.charAt(i - 1) == 'z' && str.charAt(i - 2) == 'd') {
                    answer -= 2;
                } else if (str.charAt(i - 1) == 'c' || str.charAt(i - 1) == 's' || str.charAt(i - 1) == 'z') {
                    answer--;
                }
            }
        }
        System.out.println(answer);
    }
}

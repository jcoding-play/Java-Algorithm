package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (Character.isLowerCase(str[i])) {
                str[i] = Character.toUpperCase(str[i]);
            } else {
                str[i] = Character.toLowerCase(str[i]);
            }
        }
        System.out.println(str);
    }
}

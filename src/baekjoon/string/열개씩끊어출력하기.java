package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 열개씩끊어출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while (str.length() > 10) {
            System.out.println(str.substring(0, 10));
            str = str.substring(10);
        }
        System.out.println(str);
    }
}

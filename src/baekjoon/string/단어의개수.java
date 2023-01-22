package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().strip().split(" ");

        int answer = 0;
        if (!str[0].equals("")) {
            answer = str.length;
        }
        System.out.println(answer);
    }
}

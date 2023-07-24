package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 첫글자를대문자로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char firstLetter = str.charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);

            str = firstLetter + str.substring(1);
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}

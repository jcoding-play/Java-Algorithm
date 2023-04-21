package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP는_왜KMP일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";

        String str = br.readLine();
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
            answer += split[i].charAt(0);
        }
        System.out.println(answer);
    }
}

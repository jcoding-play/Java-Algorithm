package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String n = br.readLine();
            if(n.equals("0")) break;

            String ch = "yes";
            for (int i = 0; i < (n.length()/2); i++) {
                if (n.charAt(i) != n.charAt(n.length() - 1 - i)) {
                    ch = "no";
                    break;
                }
            }
            sb.append(ch).append("\n");
        }
        System.out.println(sb);
    }
}

package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            int answer = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    count++;
                    answer += count;
                } else {
                    count = 0;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

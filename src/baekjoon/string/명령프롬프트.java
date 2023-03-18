package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str[0].length(); i++) {
            char tmp = str[0].charAt(i);
            boolean flag = true;
            for (int j = 0; j < str.length; j++) {
                if (tmp != str[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(tmp);
            } else {
                sb.append('?');
            }
        }
        System.out.println(sb);
    }
}

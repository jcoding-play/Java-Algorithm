package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (char c : s.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

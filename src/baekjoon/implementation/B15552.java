package baekjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 15552 - 빠른 A+B
 */
public class B15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(A + B).append('\n');
        }
        System.out.print(sb);
    }
}

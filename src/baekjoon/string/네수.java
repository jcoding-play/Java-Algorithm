package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long result = Long.parseLong(st.nextToken() + st.nextToken()) + Long.parseLong(st.nextToken() + st.nextToken());
        System.out.println(result);
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지능형기차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            count = count - out + in;
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}

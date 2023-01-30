package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] length = new long[n - 1];
        long[] price = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            answer += (length[i] * min);
        }
        System.out.println(answer);
    }
}

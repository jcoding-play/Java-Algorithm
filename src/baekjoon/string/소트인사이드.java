package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");

        Arrays.sort(N, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String x : N) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}

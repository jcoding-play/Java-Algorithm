package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = (i + 1) + ". ".concat(br.readLine());
        }

        Arrays.stream(names)
                .forEach(System.out::println);
    }
}

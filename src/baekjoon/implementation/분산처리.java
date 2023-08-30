package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분산처리 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = findLastComputerNumber(a, b);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    private static int findLastComputerNumber(int a, int b) {
        if (a % 10 == 1) {
            return 1;
        }
        if (a % 10 == 0) {
            return 10;
        }

        int result = a % 10;
        for (int i = 1; i < b; i++) {
            result = (result * a) % 10;
        }
        return result;
    }
}

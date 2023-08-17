package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속구간 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String number = br.readLine();

            int result = findMaxCount(number);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    private static int findMaxCount(String number) {
        int maxCount = 1;
        int count = 1;
        char lastNumber = number.charAt(0);

        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) == lastNumber) {
                maxCount = Math.max(maxCount, ++count);
                continue;
            }

            lastNumber = number.charAt(i);
            count = 1;
        }

        return maxCount;
    }
}

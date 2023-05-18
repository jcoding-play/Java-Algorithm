package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문인수 {
    public static final String NEWLINE = System.lineSeparator();
    public static final int TRUE_VALUE = 1;
    public static final int FALSE_VALUE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean flag = false;
            for (int B = 2; B <= 64; B++) {
                int[] baseDigit = convert(n, B);
                if (isPalindrome(baseDigit)) {
                    flag = true;
                    break;
                }
            }

            generateMessage(sb, flag);
            sb.append(NEWLINE);
        }
        System.out.println(sb);
    }

    private static int[] convert(int num, int B) {
        int tmp = num;
        int len = 0;
        while (tmp > 0) {
            tmp /= B;
            len++;
        }

        int[] arr = new int[len];
        len = 0;
        while (num > 0) {
            arr[len++] = num % B;
            num /= B;
        }
        return arr;
    }

    private static boolean isPalindrome(int[] baseDigit) {
        int len = baseDigit.length;
        for (int i = 0; i < len / 2; i++) {
            if (baseDigit[i] != baseDigit[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void generateMessage(StringBuilder sb, boolean flag) {
        if (flag) {
            sb.append(TRUE_VALUE);
            return;
        }
        sb.append(FALSE_VALUE);
    }
}

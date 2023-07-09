package baekjoon.string;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1120 - 문자열
 */
public class B_1120 {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int min = Integer.MAX_VALUE;
        int differenceLength = B.length() - A.length();
        for (int start = 0; start <= differenceLength; start++) {
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(start + i)) {
                    count++;
                }
            }

            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}

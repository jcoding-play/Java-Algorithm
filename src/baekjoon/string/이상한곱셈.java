package baekjoon.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 이상한곱셈 {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        String A = st.nextToken();
        String B = st.nextToken();

        long answer = calculate(A, B);

        System.out.println(answer);
    }

    private static long calculate(String A, String B) {
        long answer = 0;

        for (char num : A.toCharArray()) {
            answer += multiply(num, B);
        }

        return answer;
    }

    private static int multiply(char num, String B) {
        int result = 0;

        int value = Character.getNumericValue(num);
        for (char b : B.toCharArray()) {
            result += value * Character.getNumericValue(b);
        }

        return result;
    }
}

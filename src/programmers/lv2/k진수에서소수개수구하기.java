package programmers.lv2;

import java.util.StringTokenizer;

public class k진수에서소수개수구하기 {

    static StringBuilder sb = new StringBuilder();

    public static int solution(int n, int k) {
        int answer = 0;

        integerToKnumber(n, k);
        String kNumber = sb.toString();

        StringTokenizer st = new StringTokenizer(kNumber, "0");
        while (st.hasMoreTokens()) {
            Long number = Long.parseLong(st.nextToken());
            if (number != 1 && isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    private static void integerToKnumber(int n, int k) {
        if (n / k == 0) {
            sb.append(n);
            return;
        }

        integerToKnumber(n / k, k);
        sb.append(n % k);
    }

    private static boolean isPrime(long number) {
        for (int n = 2; n <= Math.sqrt(number); n++) {
            if (number % n == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));
    }
}

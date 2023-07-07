package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소음 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String operator = br.readLine();
        String B = br.readLine();

        System.out.println(calculate(A, B, operator));
    }

    private static String calculate(String a, String b, String operator) {
        if (operator.equals("*")) {
            return multiply(a, b);
        }
        return add(a, b);
    }

    private static String multiply(String a, String b) {
        int numberOfZeroInA = a.length() - 1;
        int numberOfZeroInB = b.length() - 1;

        int totalNumberOfZero = numberOfZeroInA + numberOfZeroInB;

        return recordResult(totalNumberOfZero).toString();
    }

    private static StringBuilder recordResult(int totalNumberOfZero) {
        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("1");
        for (int i = 0; i < totalNumberOfZero; i++) {
            resultBuilder.append("0");
        }

        return resultBuilder;
    }

    private static String add(String a, String b) {
        int lengthOfA = a.length();
        int lengthOfB = b.length();

        StringBuilder resultBuilder = recordResult(lengthOfA, lengthOfB);
        return resultBuilder.reverse().toString();
    }

    private static StringBuilder recordResult(int lengthOfA, int lengthOfB) {
        StringBuilder resultBuilder = new StringBuilder();

        int position = 1;
        while (position <= lengthOfA || position <= lengthOfB) {
            int count = 0;

            if (position == lengthOfA) {
                count++;
            }
            if (position == lengthOfB) {
                count++;
            }
            resultBuilder.append(count);
            position++;
        }

        return resultBuilder;
    }
}

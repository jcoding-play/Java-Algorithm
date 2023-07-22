package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수일까_짝수일까 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String number = br.readLine();
            EvenOrOdd status = judgeEvenOrOdd(number);

            sb.append(status.getStatus()).append('\n');
        }

        System.out.print(sb);
    }

    private static EvenOrOdd judgeEvenOrOdd(String number) {
        int len = number.length();
        int value = Character.getNumericValue(number.charAt(len - 1));

        if (value % 2 == 0) {
            return EvenOrOdd.EVEN;
        }
        return EvenOrOdd.ODD;
    }
}

enum EvenOrOdd {
    EVEN("even"),
    ODD("odd");

    private final String status;

    EvenOrOdd(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}



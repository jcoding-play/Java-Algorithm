package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밀비급일 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder resultBuilder = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("END")) {
                break;
            }

            resultBuilder.append(getReverse(str))
                    .append('\n');
        }

        System.out.print(resultBuilder);
    }

    private static StringBuilder getReverse(String str) {
        return new StringBuilder(str).reverse();
    }
}

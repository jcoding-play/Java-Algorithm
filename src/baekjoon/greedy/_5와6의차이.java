package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5와6의차이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        System.out.println(getMinValue(A, B) + " " + getMaxValue(A, B));
    }

    private static int getMinValue(String numA, String numB) {
        numA = numA.replace('6', '5');
        numB = numB.replace('6', '5');
        return Integer.parseInt(numA) + Integer.parseInt(numB);
    }

    private static int getMaxValue(String numA, String numB) {
        numA = numA.replace('5', '6');
        numB = numB.replace('5', '6');
        return Integer.parseInt(numA) + Integer.parseInt(numB);
    }
}

package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int n;
    static int[] selectedOper, arr;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        selectedOper = new int[n-1];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solution(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int L) {
        if (L == n - 1) {
            int result = calculator();
            max = Math.max(result, max);
            min = Math.min(result, min);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operators[i] != 0) {
                    operators[i]--;
                    selectedOper[L] = i;
                    solution(L + 1);
                    operators[i]++;
                }
            }
        }
    }

    private static int calculator() {
        int result = arr[0];
        for (int i = 0; i < n - 1; i++) {
            switch (selectedOper[i]) {
                case 0:
                    result += arr[i + 1];
                    break;
                case 1:
                    result -= arr[i + 1];
                    break;
                case 2:
                    result *= arr[i + 1];
                    break;
                case 3:
                    result /= arr[i + 1];
                    break;
            }
        }
        return result;
    }
}

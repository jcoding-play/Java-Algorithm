package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int negativeNumOrZeroIndex = getNegativeNumOrZeroIndex(n, arr);
        int[] negativeNumOrZero = new int[0];
        int[] positiveNum = arr.clone();
        if (negativeNumOrZeroIndex != -1) {
            negativeNumOrZero = Arrays.copyOfRange(arr, 0, negativeNumOrZeroIndex + 1);
            positiveNum = Arrays.copyOfRange(arr, negativeNumOrZeroIndex + 1, n);
        }

        System.out.println(getAnswerWithNegativeArray(negativeNumOrZero) + getAnswerWithPositiveArray(positiveNum));
    }

    private static int getNegativeNumOrZeroIndex(int n, int[] arr) {
        int negativeNumOrZeroIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= 0) {
                negativeNumOrZeroIndex = i;
                break;
            }
        }
        return negativeNumOrZeroIndex;
    }

    private static int getAnswerWithNegativeArray(int[] negativeNumOrZero) {
        int result = 0;
        for (int i = 0; i < negativeNumOrZero.length; i = i + 2) {
            int firstNum = negativeNumOrZero[i];
            if (i + 1 == negativeNumOrZero.length) {
                result += firstNum;
                break;
            }
            int secondNum = negativeNumOrZero[i + 1];

            result += firstNum * secondNum;
        }
        return result;
    }

    private static int getAnswerWithPositiveArray(int[] positiveNum) {
        int result = 0;
        for (int i = positiveNum.length - 1; i >= 0; i = i - 2) {
            int firstNum = positiveNum[i];
            if (i - 1 < 0) {
                result += firstNum;
                break;
            }
            int secondNum = positiveNum[i - 1];

            if (firstNum == 1 || secondNum == 1) {
                result += firstNum + secondNum;
                continue;
            }
            result += firstNum * secondNum;
        }
        return result;
    }
}

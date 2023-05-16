package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유레카이론 {

    static int[] triangleNumbers;
    static int triangleNumberCount;

    private static void preprocess() {
        triangleNumbers = new int[50];
        triangleNumberCount = 1;
        for (int n = 1; ; n++) {
            int triangleNumber = n * (n + 1) / 2;
            if (triangleNumber >= 1000) {
                return;
            }
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            if (isEurekaNumber(K)) {
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isEurekaNumber(int num) {
        for (int i = 1; i < triangleNumberCount; i++) {
            for (int j = 1; j < triangleNumberCount; j++) {
                for (int k = 1; k < triangleNumberCount; k++) {
                    int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (sum == num) {
                        return true;
                    }
                    if (sum > num) {
                        break;
                    }
                }
            }
        }
        return false;
    }
}

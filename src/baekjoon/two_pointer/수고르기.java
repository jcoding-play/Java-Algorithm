package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int lt = 0;
        int result;
        int answer = Integer.MAX_VALUE;
        for (int rt = 1; rt < n; rt++) {
            result = arr[rt] - arr[lt];

            while (result >= m) {
                answer = Math.min(answer, result);

                if (lt + 1 == rt) {
                    break;
                }
                result = arr[rt] - arr[++lt];
            }
        }
        System.out.println(answer);
    }
}

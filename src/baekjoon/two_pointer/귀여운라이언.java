package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 1) {
                count++;
            }

            while (count == k) {
                if (arr[lt] == 1) {
                    answer = Math.min(answer, rt - lt + 1);
                    count--;
                }
                lt++;
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}

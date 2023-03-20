package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        long answer = 0;
        int rt = -1;
        for (int lt = 0; lt < n; lt++) {
            while (rt + 1 < n && count[arr[rt + 1]] == 0) {
                rt++;
                count[arr[rt]]++;
            }

            answer += rt - lt + 1;
            count[arr[lt]]--;
        }
        System.out.println(answer);
    }
}

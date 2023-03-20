package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (solution(i, arr)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean solution(int index, int[] arr) {
        int lt = 0;
        int rt = arr.length - 1;
        int num = arr[index];
        while (lt < rt) {
            if(lt==index) lt++;
            else if(rt==index) rt--;
            else {
                if(arr[lt] + arr[rt] == num) return true;

                if(arr[lt] + arr[rt] > num) rt--;
                else lt++;
            }
        }
        return false;
    }
}

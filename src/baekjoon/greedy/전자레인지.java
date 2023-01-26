package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지 {

    static int[] time = {300, 60, 10};
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if (T % 10 != 0) {
            System.out.println(-1);
        } else {
            clickButton(T);
            for (int x : answer) {
                System.out.print(x + " ");
            }
        }
    }

    private static void clickButton(int T) {
        for (int i = 0; i < 3; i++) {
            if (T >= time[i]) {
                answer[i] = T / time[i];
                T = T % time[i];
            }
        }
    }
}

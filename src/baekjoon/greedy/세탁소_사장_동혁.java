package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세탁소_사장_동혁 {

    static int[] changeCent = {25, 10, 5, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());
            getChange(C);
        }
        System.out.print(sb);
    }

    private static void getChange(int money) {
        for (int i = 0; i < 4; i++) {
            int change =  money / changeCent[i];
            money = money % changeCent[i];

            sb.append(change).append(' ');
        }
        sb.append('\n');
    }
}

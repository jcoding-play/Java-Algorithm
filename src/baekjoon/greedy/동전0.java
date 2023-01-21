package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        while (k > 0) {
            int coin = 0;
            for (int i = 0; i < n; i++) {
                if (coins[i] <= k) {
                    coin = coins[i];
                } else {
                    break;
                }
            }
            answer += k / coin;
            k = k % coin;
        }

        System.out.println(answer);
    }
}

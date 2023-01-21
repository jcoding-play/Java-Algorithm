package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] money = {500, 100, 50, 10, 5, 1};
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;

        int answer = 0;
        for (int i = 0; i < money.length; i++) {
            if (change >= money[i]) {
                answer += change / money[i];
                change = change % money[i];
            }
        }
        System.out.println(answer);
    }
}

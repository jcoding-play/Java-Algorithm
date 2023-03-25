package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>(); //소수들만 모아두기 위한 리스트
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                list.add(i);
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < list.size(); rt++) {
            sum += list.get(rt);

            while (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= list.get(lt++);
            }
        }
        System.out.println(answer);
    }
}

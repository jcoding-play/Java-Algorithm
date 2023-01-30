package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_10610 {
    // 백준 : 30

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int n;
        int count = 0;
        while ((n = br.read()) != '\n') {
            n = n - '0';
            sum += n;
            list.add(n);
            if(n==0) count++;
        }

        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 0 && count != 0) {
            Collections.sort(list, Collections.reverseOrder());
            for (int x : list) {
                sb.append(x);
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}

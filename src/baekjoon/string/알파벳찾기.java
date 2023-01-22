package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] check = new int[26];
        Arrays.fill(check, -1);

        for (char c : S.toCharArray()) {
            int i = S.indexOf(c);
            check[c - 'a'] = i;
        }

        for (int x : check) {
            System.out.print(x + " ");
        }
    }
}

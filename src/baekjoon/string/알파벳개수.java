package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] alpha = new int[26];
        for (char tmp : str.toCharArray()) {
            alpha[tmp - 'a']++;
        }

        for (int x : alpha) {
            System.out.print(x + " ");
        }
    }
}

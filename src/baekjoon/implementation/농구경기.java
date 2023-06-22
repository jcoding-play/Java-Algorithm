package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농구경기 {
    private static int[] ch = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char firstName = name.charAt(0);

            ch[firstName - 'a']++;
        }

        String result = "";
        for (int i = 0; i < 26; i++) {
            if (ch[i] >= 5) {
                result += (char) (i + 'a');
            }
        }

        if (result.length() == 0) {
            System.out.println("PREDAJA");
        }
        System.out.println(result);
    }
}

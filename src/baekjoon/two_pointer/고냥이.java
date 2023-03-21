package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 고냥이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] alphabet = new int[26];
        int answer = 0;
        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < str.length(); rt++) {
            char tmp_rt = str.charAt(rt);

            if (alphabet[tmp_rt - 'a'] == 0) {
                count++;

                while (count > n) {
                    char tmp_lt = str.charAt(lt);

                    if (--alphabet[tmp_lt - 'a'] == 0) {
                        count--;
                    }
                    lt++;
                }
            }
            alphabet[tmp_rt - 'a']++;
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}

package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        boolean flag;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            flag = true;
            for (int j = 1; j < str.length(); j++) {
                //현재 문자가 연속된 문자가 아니면서 전에 이미 있던 문자이면 그룹 단어가 아니다.
                if (str.charAt(j - 1) != str.charAt(j) && str.indexOf(str.charAt(j)) != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}

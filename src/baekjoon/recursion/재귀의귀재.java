package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀의귀재 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();

            for (int x : solution(str[i])) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[] solution(String s) {
        int[] answer = recursion(s, 0, s.length() - 1, 1);
        return answer;
    }

    public static int[] recursion(String s, int l, int r, int count) {
        if(l>=r) return new int[]{1, count};
        else if(s.charAt(l)!=s.charAt(r)) return new int[]{0, count};
        else return recursion(s, l+1, r-1, count+1);
    }
}

package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

    static int L, C;
    static char[] alphabet;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);

        solution(0, 0, "");
        System.out.println(sb);
    }

    private static void solution(int index, int s, String result) {
        if (index == L) {
            if (checkResult(result)) {
                sb.append(result).append("\n");
            }
        } else {
            for (int i = s; i < C; i++) {
                solution(index+1, i+1, result+alphabet[i]);
            }
        }
    }

    private static boolean checkResult(String result) {
        int vowel = 0;
        int consonant = 0;
        for (char tmp : result.toCharArray()) {
            if (tmp == 'a' || tmp == 'e' || tmp == 'i' ||
                    tmp == 'o' || tmp == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}

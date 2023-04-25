package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        document = document.replace(word, "!");
        System.out.println(getAnswer(document));
    }

    private static int getAnswer(String document) {
        int answer = 0;
        for (int i = 0; i < document.length(); i++) {
            if (document.charAt(i) == '!') {
                answer++;
            }
        }
        return answer;
    }
}

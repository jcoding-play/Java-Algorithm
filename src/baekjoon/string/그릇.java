package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char lastBowl = ' ';
        int answer = 0;
        for (char bowl : str.toCharArray()) {
            if (lastBowl != bowl) {
                answer += 10;
                lastBowl = bowl;
                continue;
            }
            answer += 5;
        }
        System.out.println(answer);
    }
}

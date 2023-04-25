package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 애너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = br.readLine();
        String secondWord = br.readLine();

        int[] countFirst = getAlphabetCount(firstWord);
        int[] countSecond = getAlphabetCount(secondWord);

        System.out.println(getAnswer(countFirst, countSecond));
    }

    private static int[] getAlphabetCount(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        return count;
    }

    private static int getAnswer(int[] countFirst, int[] countSecond) {
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (countFirst[i] != countSecond[i]) {
                answer += Math.abs(countFirst[i] - countSecond[i]);
            }
        }
        return answer;
    }
}

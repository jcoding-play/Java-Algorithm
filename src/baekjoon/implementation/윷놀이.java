package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윷놀이 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            play();
        }

        System.out.println(sb);
    }

    private static void play() throws IOException {
        PlayResult playResult = new PlayResult();
        report(playResult);

        generateResultMessage(playResult);
    }

    private static void report(PlayResult playResult) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int j = 0; j < 4; j++) {
            int source = Integer.parseInt(st.nextToken());
            playResult.report(source);
        }
    }

    private static void generateResultMessage(PlayResult playResult) {
        char result = playResult.informResult();
        sb.append(result).append('\n');
    }
}

class PlayResult {
    private int oneCount;

    public void report(int result) {
        if (result == 1) {
            oneCount++;
        }
    }

    public char informResult() {
        for (int count = 0; count < 4; count++) {
            if (oneCount == count) {
                return (char) ('D' - count);
            }
        }
        return 'E';
    }
}

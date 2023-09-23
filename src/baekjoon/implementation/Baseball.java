package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baseball {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            int totalYonseiScore = 0;
            int totalKoreaScore = 0;

            for (int round = 1; round <= 9; round++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int yonseiScore = Integer.parseInt(st.nextToken());
                int koreaScore = Integer.parseInt(st.nextToken());

                totalYonseiScore += yonseiScore;
                totalKoreaScore += koreaScore;
            }

            Winner winner = Winner.of(totalYonseiScore, totalKoreaScore);
            recordWinner(winner, resultBuilder);
        }

        System.out.print(resultBuilder);
    }

    private static void recordWinner(Winner winner, StringBuilder resultBuilder) {
        resultBuilder.append(winner.getName())
                .append(System.lineSeparator());
    }

    enum Winner {
        YONSEI("Yonsei"),
        KOREA("Korea"),
        DRAW("Draw");

        private final String name;

        Winner(String name) {
            this.name = name;
        }

        public static Winner of(int yonseiScore, int koreaScore) {
            if (yonseiScore == koreaScore) {
                return DRAW;
            }
            if (yonseiScore > koreaScore) {
                return YONSEI;
            }
            return KOREA;
        }

        public String getName() {
            return name;
        }
    }
}
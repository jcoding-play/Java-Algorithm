package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10103 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player first = new Player();
        Player second = new Player();
        DiceGame diceGame = new DiceGame(first, second);

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            diceGame.compare(a, b);
        }

        System.out.println(first.getScore());
        System.out.println(second.getScore());
    }

    static class Player {
        private static final int DEFAULT_SCORE = 100;

        private int score;

        public Player() {
            score = DEFAULT_SCORE;
        }

        public void decreaseScore(int score) {
            this.score = this.score - score;
        }

        public int getScore() {
            return score;
        }
    }

    static class DiceGame {
        private final Player first;
        private final Player second;

        public DiceGame(Player first, Player second) {
            this.first = first;
            this.second = second;
        }

        public void compare(int first, int second) {
            if (first == second) {
                return;
            }
            if (first > second) {
                this.second.decreaseScore(first);
                return;
            }
            this.first.decreaseScore(second);
        }
    }
}

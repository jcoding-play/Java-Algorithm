package baekjoon.implementation.b10801.domain;

import java.util.HashMap;
import java.util.Map;

public class CardGame {
    private static final String FIRST_PLAYER_NAME = "A";
    private static final String SECOND_PLAYER_NAME = "B";
    private static final String DRAW = "D";

    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Round round;

    public CardGame(Player firstPlayer, Player secondPlayer, Round round) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.round = round;
    }

    public String findGameWinner() {
        Map<String, Integer> result = new HashMap<>();

        play(result);

        return findGameWinnerBy(result);
    }

    private void play(Map<String, Integer> result) {
        while (!isGameEnd()) {
            String roundWinner = findRoundWinner();
            result.put(roundWinner, result.getOrDefault(roundWinner, 0) + 1);
        }
    }

    private String findGameWinnerBy(Map<String, Integer> result) {
        int firstPlayerScore = result.getOrDefault(FIRST_PLAYER_NAME, 0);
        int secondPlayerScore = result.getOrDefault(SECOND_PLAYER_NAME, 0);

        return findWinnerByScore(firstPlayerScore, secondPlayerScore);
    }

    private static String findWinnerByScore(int firstPlayerScore, int secondPlayerScore) {
        if (firstPlayerScore > secondPlayerScore) {
            return FIRST_PLAYER_NAME;
        }
        if (firstPlayerScore < secondPlayerScore) {
            return SECOND_PLAYER_NAME;
        }
        return DRAW;
    }

    public String findRoundWinner() {
        int currentRound = round.getRound();
        int firstPlayerCardNumber = firstPlayer.findCardNumberOf(currentRound);
        int secondPlayerCardNumber = secondPlayer.findCardNumberOf(currentRound);

        round.decrease();

        return findRoundWinnerBy(firstPlayerCardNumber, secondPlayerCardNumber);
    }

    private String findRoundWinnerBy(int firstPlayerCardNumber, int secondPlayerCardNumber) {
        return findWinnerByScore(firstPlayerCardNumber, secondPlayerCardNumber);
    }

    public boolean isGameEnd() {
        return round.isRoundZero();
    }
}

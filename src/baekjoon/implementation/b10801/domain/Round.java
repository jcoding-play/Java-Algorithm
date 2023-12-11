package baekjoon.implementation.b10801.domain;

import java.util.Objects;

public class Round {
    private static final int DEFAULT_ROUND_VALUE = 10;
    private static final int END_GAME_VALUE = 0;

    private int round;

    Round(int round) {
        this.round = round;
    }

    public Round() {
        this.round = DEFAULT_ROUND_VALUE;
    }

    public void decrease() {
        this.round--;
    }

    public boolean isRoundZero() {
        return round == END_GAME_VALUE;
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}

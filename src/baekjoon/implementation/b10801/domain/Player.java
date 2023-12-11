package baekjoon.implementation.b10801.domain;

import java.util.List;

public class Player {
    private final Cards cards;

    public Player(List<Integer> numbers) {
        this.cards = new Cards(numbers);
    }

    public int findCardNumberOf(int round) {
        Card card = cards.findCardOf(round);
        return card.getNumber();
    }
}

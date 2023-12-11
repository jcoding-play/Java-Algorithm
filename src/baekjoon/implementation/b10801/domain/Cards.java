package baekjoon.implementation.b10801.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cards {
    private static final int CARDS_SIZE = 10;

    private final List<Card> cards;

    public Cards(List<Integer> numbers) {
        validateCards(numbers);
        this.cards = mapCard(numbers);
    }

    private void validateCards(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(
                    String.format("카드의 개수는 %d장이어야 합니다.", CARDS_SIZE));
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("카드의 숫자는 중복될 수 없습니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != CARDS_SIZE;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private List<Card> mapCard(List<Integer> numbers) {
        return numbers.stream()
                .map(Card::new)
                .collect(Collectors.toList());
    }

    public Card findCardOf(int round) {
        return cards.get(round - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards1 = (Cards) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}

package baekjoon.implementation.b10801.domain;

import java.util.Objects;

public class Card {
    private static final int MINIMUM_CARD_NUMBER = 1;
    private static final int MAXIMUM_CARD_NUMBER = 10;

    private final int number;

    public Card(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MINIMUM_CARD_NUMBER || number > MAXIMUM_CARD_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("카드의 숫자는 %d에서 %d사이의 값이어야 합니다.", MINIMUM_CARD_NUMBER, MAXIMUM_CARD_NUMBER));
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

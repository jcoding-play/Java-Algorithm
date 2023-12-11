package baekjoon.implementation.b10801.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("카드는 1~10 범위의 숫자로 이루어져 있다.")
    void createCard(int number) {
        Card card = new Card(number);
        assertEquals(new Card(number), card);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("카드의 숫자가 1보다 작거나 10보다 크다면 예외가 발생한다.")
    void invalidCard(int number) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Card(number));
        assertEquals("카드의 숫자는 1에서 10사이의 값이어야 합니다.", exception.getMessage());
    }
}
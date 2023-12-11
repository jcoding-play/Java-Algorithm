package baekjoon.implementation.b10801.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    @Test
    @DisplayName("게임에 사용되는 카드들은 1부터 10까지의 숫자가 하나씩 적힌 열 장의 카드이다.")
    void createCards() {
        Cards cards = new Cards(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(new Cards(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), cards);
    }

    @Test
    @DisplayName("카드의 숫자가 중복되면 예외가 발생한다.")
    void hasDuplicatedNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cards(List.of(1, 1, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertEquals("카드의 숫자는 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("카드의 수가 10장이 아니라면 예외가 발생한다.")
    void invalidSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Cards(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertEquals("카드의 개수는 10장이어야 합니다.", exception.getMessage());
    }
}
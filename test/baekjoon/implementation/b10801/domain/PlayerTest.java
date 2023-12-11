package baekjoon.implementation.b10801.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "10, 10"})
    @DisplayName("플레이어는 각 라운드에서 사용할 카드의 숫자를 알 수 있다.")
    void findCardNumber(int round, int expected) {
        Player player = new Player(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int actual = player.findCardNumberOf(round);

        assertEquals(expected, actual);
    }
}
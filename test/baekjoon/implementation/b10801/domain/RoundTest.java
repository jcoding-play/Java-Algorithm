package baekjoon.implementation.b10801.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    @DisplayName("게임을 진행할 라운드를 알 수 있다.")
    void createRound() {
        Round round = new Round();
        assertEquals(new Round(10), round);
    }
}
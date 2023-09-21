package baekjoon.implementation.b8979.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedalTest {

    @Test
    @DisplayName("금메달, 은메달, 동메달의 개수를 알 수 있다.")
    void create() {
        Medal medal = new Medal(1, 1, 1);
        assertEquals(new Medal(1, 1, 1), medal);
    }

    @Test
    @DisplayName("메달의 개수가 음수인 것이 있다면 예외가 발생한다.")
    void invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Medal(1, -1, 1));
        assertEquals("메달의 개수가 0보다 작을 수 없습니다.", exception.getMessage());
    }
}
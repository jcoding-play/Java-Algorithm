package baekjoon.implementation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceGameTest {

    @Test
    @DisplayName("가장 많은 상금을 받는 사람의 상금을 알 수 있다.")
    void findMaxPrizeMoney() {
        Player first = new Player("3 3 6");
        Player second = new Player("2 2 2");
        Player third = new Player("6 2 5");

        DiceGame diceGame = new DiceGame(List.of(first, second, third));
        int result = diceGame.findMaxPrizeMoney();

        assertEquals(12000, result);
    }
}
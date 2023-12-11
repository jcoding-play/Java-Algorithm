package baekjoon.implementation.b10801.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {

    @Test
    @DisplayName("각 라운드별 승자를 알 수 있다.")
    void findRoundWinner() {
        Player firstPlayer = new Player(List.of(6, 7, 5, 1, 4, 10, 2, 3, 8, 9));
        Player secondPlayer = new Player(List.of(1, 10, 2, 9, 4, 8, 3, 7, 5, 6));
        CardGame cardGame = new CardGame(firstPlayer, secondPlayer, new Round());

        String roundWinner = cardGame.findRoundWinner();

        assertEquals("A", roundWinner);
    }

    @Test
    @DisplayName("게임이 종료되었는지 알 수 있다.")
    void isGameEnd() {
        Player firstPlayer = new Player(List.of(6, 7, 5, 1, 4, 10, 2, 3, 8, 9));
        Player secondPlayer = new Player(List.of(1, 10, 2, 9, 4, 8, 3, 7, 5, 6));
        CardGame cardGame = new CardGame(firstPlayer, secondPlayer, new Round(2));

        cardGame.findRoundWinner();
        assertFalse(cardGame.isGameEnd());

        cardGame.findRoundWinner();
        assertTrue(cardGame.isGameEnd());
    }

    @Test
    @DisplayName("전체 게임의 승자를 구할 수 있다.")
    void findGameWinner() {
        Player firstPlayer = new Player(List.of(6, 7, 5, 1, 4, 10, 2, 3, 8, 9));
        Player secondPlayer = new Player(List.of(1, 10, 2, 9, 4, 8, 3, 7, 5, 6));
        CardGame cardGame = new CardGame(firstPlayer, secondPlayer, new Round());

        String winner = cardGame.findGameWinner();

        assertEquals("A", winner);
    }
}
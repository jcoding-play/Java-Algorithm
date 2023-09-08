package baekjoon.implementation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("같은 눈이 3개가 있으면 10,000원 + (같은 눈 * 1,000)원의 상금을 받는다.")
    void calculatePrizeV1() {
        Player player = new Player("2 2 2");
        int result = player.calculatePrize();
        assertEquals(12000, result);
    }

    @Test
    @DisplayName("같은 눈이 2개가 있으면 1,000원 + (같은 눈 * 100)원의 상금을 받는다.")
    void calculatePrizeV2() {
        Player player = new Player("3 3 6");
        int result = player.calculatePrize();
        assertEquals(1300, result);
    }

    @Test
    @DisplayName("같은 눈이 하나도 없으면 (가장 큰 눈 * 100)원의 상금을 받는다.")
    void calculatePrizeV3() {
        Player player = new Player("6 2 5");
        int result = player.calculatePrize();
        assertEquals(600, result);
    }

    @Test
    @DisplayName("같은 눈이 3개가 있으면 그 눈을 알려준다.")
    void findScoreV1() {
        Player player = new Player("2 2 2");
        int score = player.findScore();
        assertEquals(2, score);
    }

    @Test
    @DisplayName("같은 눈이 2개가 있고, 다른 눈이 하나 있으면 2개짜리 눈을 알려준다.")
    void findScoreV2() {
        Player player = new Player("3 3 6");
        int score = player.findScore();
        assertEquals(3, score);
    }

    @Test
    @DisplayName("같은 눈이 아무것도 없으면 그 중 가장 큰 값을 알려준다.")
    void findScoreV3() {
        Player player = new Player("5 2 6");
        int score = player.findScore();
        assertEquals(6, score);
    }
}
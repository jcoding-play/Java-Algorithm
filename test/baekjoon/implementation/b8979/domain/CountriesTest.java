package baekjoon.implementation.b8979.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountriesTest {

    @Test
    @DisplayName("올림픽에 참여하는 나라들의 정보를 알 수 있다.")
    void create() {
        List<Country> countryList = List.of(
                new Country(1, new Medal(1, 1, 1)),
                new Country(2, new Medal(3, 1, 2)),
                new Country(3, new Medal(3, 2, 1))
        );
        Countries countries = new Countries(countryList);
        assertEquals(new Countries(countryList), countries);
    }

    @Test
    @DisplayName("올림픽에 참여하는 나라의 수가 1보다 작으면 예외가 발생한다.")
    void invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Countries(Collections.emptyList()));
        assertEquals("올림픽에 참여하는 나라는 최소 1이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("나라들간의 순위를 알 수 있다.")
    void findRankings_V1() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 1, 1)),
                new Country(2, new Medal(4, 2, 2)),
                new Country(3, new Medal(3, 1, 1))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(3, rankings.get(1));
        assertEquals(1, rankings.get(2));
        assertEquals(2, rankings.get(3));
    }

    @Test
    @DisplayName("금메달의 수가 모두 같으면 은메달의 개수에 따라 순위를 정한다.")
    void findRankings_V2() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 3, 1)),
                new Country(2, new Medal(1, 1, 2)),
                new Country(3, new Medal(1, 2, 1))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(1, rankings.get(1));
        assertEquals(3, rankings.get(2));
        assertEquals(2, rankings.get(3));
    }

    @Test
    @DisplayName("금메달, 은메달의 수가 모두 같으면 동메달의 개수에 따라 순위를 정한다.")
    void findRankings_V3() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 1, 3)),
                new Country(2, new Medal(1, 1, 2)),
                new Country(3, new Medal(1, 1, 1))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(1, rankings.get(1));
        assertEquals(2, rankings.get(2));
        assertEquals(3, rankings.get(3));
    }

    @Test
    @DisplayName("동일한 메달의 개수를 가진 나라들이 있으면 공동 순위이다.")
    void findRankings_V4() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 1, 1)),
                new Country(2, new Medal(1, 1, 1)),
                new Country(3, new Medal(1, 1, 1))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(1, rankings.get(1));
        assertEquals(1, rankings.get(2));
        assertEquals(1, rankings.get(3));
    }

    @Test
    @DisplayName("동일한 메달의 개수를 가진 나라들이 있으면 공동 순위이다.")
    void findRankings_V5() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 1, 2)),
                new Country(2, new Medal(1, 1, 2)),
                new Country(3, new Medal(1, 1, 1)),
                new Country(4, new Medal(1, 1, 1))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(1, rankings.get(1));
        assertEquals(1, rankings.get(2));
        assertEquals(3, rankings.get(3));
        assertEquals(3, rankings.get(4));
    }

    @Test
    @DisplayName("동일한 메달의 개수를 가진 나라들이 있으면 공동 순위이다.")
    void findRankings_V6() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(4, 0, 0)),
                new Country(2, new Medal(4, 0, 0)),
                new Country(3, new Medal(2, 0, 0)),
                new Country(4, new Medal(1, 0, 0))
        );
        Countries countries = new Countries(countryList);

        Map<Integer, Integer> rankings = countries.findRankings();
        assertEquals(1, rankings.get(1));
        assertEquals(1, rankings.get(2));
        assertEquals(3, rankings.get(3));
        assertEquals(4, rankings.get(4));
    }

    @Test
    @DisplayName("특정 나라의 순위를 알 수 있다.")
    void findRankingOf() {
        List<Country> countryList = Arrays.asList(
                new Country(1, new Medal(1, 1, 2)),
                new Country(2, new Medal(1, 1, 2)),
                new Country(3, new Medal(1, 1, 1)),
                new Country(4, new Medal(1, 1, 1))
        );
        Countries countries = new Countries(countryList);

        assertEquals(1, countries.findRankingOf(1));
        assertEquals(3, countries.findRankingOf(4));
    }
}
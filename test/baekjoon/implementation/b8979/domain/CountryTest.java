package baekjoon.implementation.b8979.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    @DisplayName("각 나라의 이름과 메달의 개수를 알 수 있다.")
    void create() {
        Country country = new Country(1, new Medal(1, 1, 1));
        assertEquals(new Country(1, new Medal(1, 1, 1)), country);
    }

    @Test
    @DisplayName("나라의 이름이 1보다 작으면 예외가 발생한다.")
    void invalidCountryName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Country(0, new Medal(1, 1, 1)));
        assertEquals("나라의 이름은 최소 1이상이어야 합니다.", exception.getMessage());
    }
}
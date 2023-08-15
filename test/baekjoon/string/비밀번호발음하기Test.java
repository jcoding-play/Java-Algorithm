package baekjoon.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class 비밀번호발음하기Test {
    private 비밀번호발음하기 main = new 비밀번호발음하기();

    @ParameterizedTest
    @CsvSource(value = {"sd, true", "as, false"})
    void isNotContainsVowel(String password, boolean expected) {
        boolean actual = main.isNotContainsVowel(password);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"aei, true", "ais, false"})
    void isVowelContinuous(String password, boolean expected) {
        boolean actual = main.isVowelContinuous(password);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"sdf, true", "sef, false"})
    void isConsonantContinuous(String password, boolean expected) {
        boolean actual = main.isConsonantContinuous(password);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"baa, true", "abb, true", "cee, false", "coo, false"})
    void isSameLetterContinuous(String password, boolean expected) {
        boolean actual = main.isSameLetterContinuous(password);
        assertEquals(expected, actual);
    }
}
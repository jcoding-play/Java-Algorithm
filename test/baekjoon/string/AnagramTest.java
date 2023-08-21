package baekjoon.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @ParameterizedTest
    @CsvSource(value = {"blather, reblath, true", "maryland, landam, false"})
    void isAnagram(String firstWord, String secondWord, boolean expected) {
        Anagram anagram = Anagram.of(firstWord, secondWord);
        boolean actual = anagram.isAnagram();
        assertEquals(expected, actual);
    }
}
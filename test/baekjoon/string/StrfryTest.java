package baekjoon.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StrfryTest {
    private Strfry strfry;

    @BeforeEach
    void setUp() {
        strfry = new Strfry();
    }

    @ParameterizedTest
    @CsvSource(value = {"abc, bca, Possible", "abc, bra, Impossible"})
    void compareTest(String first, String second, String expected) {
        String actual = strfry.compare(first, second);
        assertEquals(expected, actual);
    }
}
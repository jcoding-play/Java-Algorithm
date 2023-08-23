package baekjoon.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordAnalyzerTest {
    private WordAnalyzer wordAnalyzer;

    @BeforeEach
    void setUp() {
        wordAnalyzer = new WordAnalyzer("DOG");
    }

    @Test
    void analyze() {
        int[] count = wordAnalyzer.analyze("GOOD");

        assertEquals(1, count['G' - 'A']);
        assertEquals(2, count['O' - 'A']);
        assertEquals(1, count['D' - 'A']);
    }

    @ParameterizedTest
    @CsvSource(value = {"GOD, true", "GOOD, true", "DOLL, false"})
    void isSimilarWord(String word, boolean expected) {
        boolean actual = wordAnalyzer.isSimilarWord(word);
        assertEquals(expected, actual);
    }
}
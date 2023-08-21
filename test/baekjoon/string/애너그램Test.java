package baekjoon.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class 애너그램Test {
    private 애너그램 main = new 애너그램();

    @ParameterizedTest
    @MethodSource("anagramAndMessage")
    void generateMessageOf(Anagram anagram, String expected) {
        String actual = main.generateMessageOf(anagram);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> anagramAndMessage() {
        return Stream.of(
                arguments(Anagram.of("blather", "reblath"), "blather & reblath are anagrams."),
                arguments(Anagram.of("maryland", "landam"), "maryland & landam are NOT anagrams.")
        );
    }
}
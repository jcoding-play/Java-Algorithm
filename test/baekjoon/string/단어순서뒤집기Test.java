package baekjoon.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class 단어순서뒤집기Test {
    private 단어순서뒤집기 main;

    @BeforeEach
    void setUp() {
        main = new 단어순서뒤집기();
    }

    @Test
    void buildMessage() {
        String result = main.buildMessage(2, "this is a test");
        assertEquals("Case #2: test a is this", result);
    }

    @Test
    void reverse() {
        List<String> words = main.findWords("all your base");
        assertEquals("all", words.get(0));
        assertEquals("base", words.get(2));

        words = main.reverse(words);
        assertEquals("base", words.get(0));
        assertEquals("all", words.get(2));
    }
}
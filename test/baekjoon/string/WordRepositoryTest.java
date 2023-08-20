package baekjoon.string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordRepositoryTest {
    private WordRepository wordRepository;

    @BeforeEach
    void setUp() {
        wordRepository = new WordRepository();
    }

    @AfterEach
    void tearDown() {
        wordRepository.clearStore();
    }

    @Test
    void save() {
        wordRepository.save("apple");

        boolean result1 = wordRepository.isSaved("apple");
        boolean result2 = wordRepository.isSaved("sand");
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    @DisplayName("자주 나오는 단어를 먼저 나타내준다.")
    void findWordsV1() {
        wordRepository.save("apple");
        wordRepository.save("apple");
        wordRepository.save("sand");
        wordRepository.save("sand");
        wordRepository.save("sand");
        wordRepository.save("ant");

        List<String> words = wordRepository.findWords();
        assertEquals("sand", words.get(0));
        assertEquals("apple", words.get(1));
        assertEquals("ant", words.get(2));
    }

    @Test
    @DisplayName("단어가 나타낸 개수가 동일할 경우 단어의 길이가 길수록 먼저 배치한다.")
    void findWordsV2() {
        wordRepository.save("apple");
        wordRepository.save("sand");
        wordRepository.save("ant");

        List<String> words = wordRepository.findWords();
        assertEquals("apple", words.get(0));
        assertEquals("sand", words.get(1));
        assertEquals("ant", words.get(2));
    }

    @Test
    @DisplayName("단어가 나타낸 개수가 동일하고 단어의 길이 또한 동일하면 알파벳 사전 순으로 배치한다.")
    void findWordsV3() {
        wordRepository.save("abc");
        wordRepository.save("xyz");
        wordRepository.save("qrs");

        List<String> words = wordRepository.findWords();
        assertEquals("abc", words.get(0));
        assertEquals("qrs", words.get(1));
        assertEquals("xyz", words.get(2));
    }
}
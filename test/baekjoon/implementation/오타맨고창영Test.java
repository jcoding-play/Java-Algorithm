package baekjoon.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 오타맨고창영Test {
    private 오타맨고창영 main;

    @BeforeEach
    void setUp() {
        main = new 오타맨고창영();
    }

    @Test
    @DisplayName("오타를 낸 위치와 문자열을 통해 오타를 지운 문자열을 알 수 있다.")
    void modify() {
        assertEquals("MISPELL", main.modify(4, "MISSPELL"));
        assertEquals("ROGRAMMING", main.modify(1, "PROGRAMMING"));
        assertEquals("CONTES", main.modify(7, "CONTEST"));
        assertEquals("BALOON", main.modify(3, "BALLOON"));
    }
}
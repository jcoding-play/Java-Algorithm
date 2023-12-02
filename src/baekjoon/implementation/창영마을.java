package baekjoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class 창영마을 {
    private static Map<Character, Consumer<boolean[]>> map = new HashMap<>();

    static {
        map.put('A', booleans -> {
            boolean tmp = booleans[1];
            booleans[1] = booleans[2];
            booleans[2] = tmp;
        });
        map.put('B', booleans -> {
            boolean tmp = booleans[2];
            booleans[2] = booleans[3];
            booleans[3] = tmp;
        });
        map.put('C', booleans -> {
            boolean tmp = booleans[1];
            booleans[1] = booleans[3];
            booleans[3] = tmp;
        });
    }

    public static void main(String[] args) {
        boolean[] hasBall = new boolean[4];
        hasBall[1] = true;

        String input = new Scanner(System.in).nextLine();

        input.chars()
                .forEach(letter -> map.get((char) letter).accept(hasBall));

        IntStream.rangeClosed(1, 3)
                .filter(index -> hasBall[index])
                .forEach(System.out::println);
    }
}

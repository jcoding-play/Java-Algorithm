package baekjoon.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UCPC는_무엇의_약자일까 {
    private static final String UCPC = "UCPC";

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        Queue<Character> queue = new LinkedList<>();
        initQueue(queue);

        for (char letter : input.toCharArray()) {
            if (queue.isEmpty()) {
                break;
            }

            if (letter == queue.peek()) {
                queue.poll();
            }
        }

        printResult(queue);
    }

    private static void initQueue(Queue<Character> queue) {
        Arrays.stream(UCPC.split(""))
                .forEach(letter -> queue.add(letter.charAt(0)));
    }

    private static void printResult(Queue<Character> queue) {
        if (queue.isEmpty()) {
            System.out.println("I love UCPC");
            return;
        }
        System.out.println("I hate UCPC");
    }
}

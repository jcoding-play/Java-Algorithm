package baekjoon.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 카드1 {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> result = new LinkedList<>();
        while (queue.size() > 1) {
            result.add(queue.poll());
            queue.add(queue.poll());
        }
        result.add(queue.poll());

        result.forEach(number -> System.out.print(number + " "));
    }
}

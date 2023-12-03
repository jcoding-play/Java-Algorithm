package baekjoon.implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 계산기프로그램 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = initializeQueue(scanner);

        int result = Integer.parseInt(queue.poll());
        while (!queue.isEmpty()) {
            String operator = queue.poll();
            int second = Integer.parseInt(queue.poll());

            result = calculate(result, operator, second);
        }

        System.out.println(result);
    }

    private static Queue<String> initializeQueue(Scanner scanner) {
        Queue<String> queue = new LinkedList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("=")) {
                break;
            }

            queue.offer(input);
        }

        return queue;
    }

    private static int calculate(int first, String operator, int second) {
        if (operator.equals("+")) {
            return first + second;
        }
        if (operator.equals("-")) {
            return first - second;
        }
        if (operator.equals("*")) {
            return first * second;
        }
        return first / second;
    }
}

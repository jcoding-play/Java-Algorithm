package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 덱 {
    private static final String NEWLINE = System.lineSeparator();

    static Deque<Integer> deque = new ArrayDeque<>();
    static Map<Boolean, Integer> resultMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static {
        resultMap.put(true, 1);
        resultMap.put(false, 0);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            order(br);
        }
        System.out.println(sb);
    }

    private static void order(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String command = st.nextToken();

        if (st.hasMoreTokens()) {
            run(command, Integer.parseInt(st.nextToken()));
            return;
        }
        run(command);
    }

    private static void run(String command) {
        if (command.equals("size")) {
            report(deque.size());
            return;
        }
        if (command.equals("empty")) {
            report(resultMap.get(deque.isEmpty()));
            return;
        }

        runWithDequeNumber(command);
    }

    private static void runWithDequeNumber(String command) {
        if (deque.isEmpty()) {
            report(-1);
            return;
        }
        if (command.equals("front")) {
            report(deque.peekFirst());
            return;
        }
        if (command.equals("back")) {
            report(deque.peekLast());
            return;
        }
        if (command.equals("pop_front")) {
            report(deque.poll());
            return;
        }
        report(deque.pollLast());
    }

    private static void report(Object input) {
        sb.append(input)
                .append(NEWLINE);
    }

    private static void run(String command, int x) {
        if (command.equals("push_front")) {
            deque.offerFirst(x);
            return;
        }
        deque.offerLast(x);
    }
}

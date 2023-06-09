package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
    private static final String NEWLINE = System.lineSeparator();

    static Queue<Paper> queue;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(reader.readLine());

        run(T);
        printResult();
    }

    private static void run(int T) throws IOException {
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            initQueue(N);
            buildMessage(M);
        }
    }

    private static void initQueue(int N) throws IOException {
        queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int index = 0; index < N; index++) {
            int importance = Integer.parseInt(st.nextToken());
            queue.add(new Paper(importance, index));
        }
    }

    private static void buildMessage(int index) {
        resultBuilder.append(calculateResult(index))
                .append(NEWLINE);
    }

    private static int calculateResult(int index) {
        int count = 1;

        while (true) {
            Paper paper = queue.poll();
            Paper mostImportantPaper = compareWith(paper);

            if (isNotMostImportantPaper(paper, mostImportantPaper)) continue;

            if (paper.isMatch(index)) {
                return count;
            }
            count++;
        }
    }

    private static Paper compareWith(Paper paper) {
        for (Paper tmp : queue) {
            if (tmp.isMoreImportantThan(paper)) {
                queue.offer(paper);
                return tmp;
            }
        }
        return paper;
    }

    private static boolean isNotMostImportantPaper(Paper paper, Paper other) {
        return !paper.equals(other);
    }

    private static void printResult() {
        System.out.println(resultBuilder);
    }

    static class Paper {
        private final int importance;
        private final int index;

        public Paper(int importance, int index) {
            this.importance = importance;
            this.index = index;
        }

        public boolean isMoreImportantThan(Paper paper) {
            return this.importance > paper.importance;
        }

        public boolean isMatch(int index) {
            return this.index == index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Paper paper = (Paper) o;
            return importance == paper.importance && index == paper.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(importance, index);
        }
    }
}
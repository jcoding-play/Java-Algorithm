package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 내학점을구해줘 {
    private static final String BLANK = " ";
    private static final String NEWLINE = System.lineSeparator();

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(reader.readLine());

        StringBuilder resultBuilder = new StringBuilder();
        while (T-- > 0) {
            Classes classes = initClasses(Integer.parseInt(reader.readLine()));
            int totalCredit = classes.calculateTotalCredit();
            double average = classes.calculateAverage();

            recordResult(resultBuilder, totalCredit, average);
        }

        System.out.print(resultBuilder);
    }

    private static Classes initClasses(int N) throws IOException {
        Classes classes = new Classes();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int C = Integer.parseInt(st.nextToken());
            double G = Double.parseDouble(st.nextToken());

            classes.add(new Class(C, G));
        }

        return classes;
    }

    private static void recordResult(StringBuilder resultBuilder, int totalCredit, double average) {
        resultBuilder.append(totalCredit)
                .append(BLANK)
                .append(String.format("%.1f", average))
                .append(NEWLINE);
    }
    
    static class Classes {

        private final List<Class> classes = new ArrayList<>();

        public void add(Class source) {
            classes.add(source);
        }

        public int calculateTotalCredit() {
            return classes.stream()
                    .map(Class::getCredit)
                    .reduce(0, Integer::sum);
        }

        public double calculateAverage() {
            return calculateGPA() / calculateTotalCredit();
        }

        private double calculateGPA() {
            return classes.stream()
                    .map(Class::calculateGPA)
                    .reduce(0.0, Double::sum);
        }
    }

    static class Class {
        private final int credit;
        private final double score;

        public Class(int credit, double score) {
            this.credit = credit;
            this.score = score;
        }

        public double calculateGPA() {
            return credit * score;
        }

        public int getCredit() {
            return credit;
        }
    }
}

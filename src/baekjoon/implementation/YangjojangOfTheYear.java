package baekjoon.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YangjojangOfTheYear {
    private static final String DELIMITER = " ";
    private static final String NEWLINE = System.lineSeparator();

    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());

            Yangjojang yangjojang = findMaxYangjojang(initYangjojangs(N));
            report(yangjojang);
        }

        System.out.print(resultBuilder);
    }

    private static List<Yangjojang> initYangjojangs(int N) {
        return Stream.generate(() -> generateYangjojang())
                .limit(N)
                .collect(Collectors.toList());
    }

    private static Yangjojang generateYangjojang() {
        String[] input = scanner.nextLine().split(DELIMITER);
        String university = input[0];
        int amountOfAlcohol = Integer.parseInt(input[1]);

        return new Yangjojang(university, amountOfAlcohol);
    }

    private static Yangjojang findMaxYangjojang(List<Yangjojang> yangjojangs) {
        return yangjojangs.stream()
                .max(Yangjojang::compareTo)
                .get();
    }

    private static void report(Yangjojang yangjojang) {
        resultBuilder.append(yangjojang.getUniversity())
                .append(NEWLINE);
    }

    static class Yangjojang implements Comparable<Yangjojang> {
        private final String university;
        private final int amountOfAlcohol;

        public Yangjojang(String university, int amountOfAlcohol) {
            this.university = university;
            this.amountOfAlcohol = amountOfAlcohol;
        }

        public String getUniversity() {
            return university;
        }

        @Override
        public int compareTo(Yangjojang other) {
            return this.amountOfAlcohol - other.amountOfAlcohol;
        }
    }
}
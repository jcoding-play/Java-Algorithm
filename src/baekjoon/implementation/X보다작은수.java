package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class X보다작은수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        printNumbers(numbers, X);
    }

    private static void printNumbers(List<Integer> numbers, int x) {
        Conditional conditional = new NumberConditional();

        numbers.stream()
                .filter(number -> conditional.test(number, x))
                .forEach(number -> System.out.print(number + " "));
    }

    interface Conditional {
        boolean test(int number, int x);
    }

    static class NumberConditional implements Conditional {
        @Override
        public boolean test(int number, int x) {
            return number < x;
        }
    }
}

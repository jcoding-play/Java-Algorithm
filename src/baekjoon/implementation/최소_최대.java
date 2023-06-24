package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최소_최대 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = initializeNumbers(br, N);

        printMinValue(numbers);
        printMaxValue(numbers);
    }

    private static List<Integer> initializeNumbers(BufferedReader br, int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        return numbers;
    }

    private static void printMinValue(List<Integer> numbers) {
        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(number -> System.out.print(number + " "));
    }

    private static void printMaxValue(List<Integer> numbers) {
        numbers.stream()
                .max(Integer::compareTo)
                .ifPresent(number -> System.out.print(number + " "));
    }
}

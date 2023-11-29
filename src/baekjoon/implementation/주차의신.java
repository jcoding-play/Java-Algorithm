package baekjoon.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 주차의신 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        StringBuilder resultBuilder = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> distances = initializeDistances(scanner, n);

            int result = calculateMinDistance(distances, n);
            resultBuilder.append(result).append(System.lineSeparator());
        }

        System.out.print(resultBuilder);
    }

    private static List<Integer> initializeDistances(Scanner scanner, int n) {
        List<Integer> distances = new ArrayList<>();

        String input = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] numbers = input.split(" ");
            distances.add(Integer.parseInt(numbers[i]));
        }

        Collections.sort(distances);
        return distances;
    }

    private static int calculateMinDistance(List<Integer> distances, int n) {
        return (distances.get(n - 1) - distances.get(0)) * 2;
    }
}

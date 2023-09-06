package baekjoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 저항 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long result = 0L;

        for (int i = 1; i <= 3; i++) {
            result = calculate(scanner, result, i);
        }

        System.out.println(result);
    }

    private static long calculate(Scanner scanner, long result, int i) {
        Value value = Repository.findByColor(scanner.nextLine());
        return value.calculate(i, result);
    }

    static class Repository {
        private static Map<String, Value> store = new HashMap<>();

        static {
            addValue("black", 0, 1);
            addValue("brown", 1, 10);
            addValue("red", 2, 100);
            addValue("orange", 3, 1000);
            addValue("yellow", 4, 10000);
            addValue("green", 5, 100000);
            addValue("blue", 6, 1000000);
            addValue("violet", 7, 10000000);
            addValue("grey", 8, 100000000);
            addValue("white", 9, 1000000000);
        }

        private static void addValue(String color, int value, int multiply) {
            store.put(color, new Value(value, multiply));
        }

        public static Value findByColor(String color) {
            return store.get(color);
        }
    }

    static class Value {
        private final int value;
        private final int multiply;

        public Value(int value, int multiply) {
            this.value = value;
            this.multiply = multiply;
        }

        public long calculate(int index, long result) {
            if (index == 3) {
                return multiply(result);
            }
            return add(result);
        }

        private long multiply(long result) {
            return result * multiply;
        }

        private long add(long result) {
            return Long.parseLong(result + String.valueOf(value));
        }
    }
}

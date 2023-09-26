package baekjoon.implementation;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 대지 {
    private static final String POINT_DELIMITER = " ";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = Integer.parseInt(scanner.nextLine());

        List<Point> points = initPoints(N);

        int width = calculateDistance(points, Point::getX);
        int height = calculateDistance(points, Point::getY);

        System.out.println(calculateArea(width, height));
    }

    private static List<Point> initPoints(int N) {
        return Stream.generate(() -> generatePoint())
                .limit(N)
                .collect(Collectors.toList());
    }

    private static Point generatePoint() {
        String[] input = scanner.nextLine().split(POINT_DELIMITER);
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        return new Point(x, y);
    }

    private static int calculateDistance(List<Point> points, Function<Point, Integer> function) {
        int maxPoint = findMaxPointOf(points, function);
        int minPoint = findMinPointOf(points, function);

        return maxPoint - minPoint;
    }

    private static int findMaxPointOf(List<Point> points, Function<Point, Integer> function) {
        return points.stream()
                .map(function)
                .max(Comparator.naturalOrder())
                .get();
    }

    private static int findMinPointOf(List<Point> points, Function<Point, Integer> function) {
        return points.stream()
                .map(function)
                .min(Comparator.naturalOrder())
                .get();
    }

    private static int calculateArea(int width, int height) {
        return width * height;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

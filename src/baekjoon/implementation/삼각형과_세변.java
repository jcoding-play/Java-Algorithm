package baekjoon.implementation;

import java.util.*;

public class 삼각형과_세변 {
    private static final String NEWLINE = System.lineSeparator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (isOver(a, b, c)) {
                break;
            }

            Triangle triangle = new Triangle(a, b, c);
            String result = triangle.calculateResult();
            sb.append(result).append(NEWLINE);
        }

        System.out.print(sb);
    }

    private static boolean isOver(int a, int b, int c) {
        return a == 0 && b == 0 && c == 0;
    }
}

class Triangle {
    private static final String INVALID = "Invalid";
    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";

    private final List<Integer> sides;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.sides = initSides(firstSide, secondSide, thirdSide);
    }

    private List<Integer> initSides(int firstSide, int secondSide, int thirdSide) {
        List<Integer> sides = new ArrayList<>();

        sides.add(firstSide);
        sides.add(secondSide);
        sides.add(thirdSide);

        return sides;
    }

    public String calculateResult() {
        Collections.sort(sides);

        if (isInvalidTriangle()) {
            return INVALID;
        }
        return checkTriangle();
    }

    private String checkTriangle() {
        Set<Integer> triangleSides = new HashSet<>(sides);

        if (triangleSides.size() == 1) {
            return EQUILATERAL;
        }
        if (triangleSides.size() == 2) {
            return ISOSCELES;
        }
        return SCALENE;
    }

    private boolean isInvalidTriangle() {
        return sides.get(0) + sides.get(1) <= sides.get(2);
    }
}
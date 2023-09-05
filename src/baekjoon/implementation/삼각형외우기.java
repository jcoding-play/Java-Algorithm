package baekjoon.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 삼각형외우기 {
    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumOfAngles = 0;
        Set<Integer> angles = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int angle = scanner.nextInt();

            angles.add(angle);
            sumOfAngles += angle;
        }

        if (sumOfAngles != 180) {
            System.out.println("Error");
            return;
        }
        showTriangleInfo(angles);
    }

    private static void showTriangleInfo(Set<Integer> angles) {
        if (angles.size() == 1) {
            System.out.println(EQUILATERAL);
            return;
        }
        if (angles.size() == 2) {
            System.out.println(ISOSCELES);
            return;
        }
        if (angles.size() == 3) {
            System.out.println(SCALENE);
            return;
        }
        throw new IllegalArgumentException("삼각형이 아닙니다.");
    }
}

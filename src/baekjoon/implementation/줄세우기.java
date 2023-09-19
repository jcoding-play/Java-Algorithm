package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class 줄세우기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudent = scanner.nextInt();

        int[] students = initStudents(numberOfStudent);

        for (int index = 0; index < numberOfStudent; index++) {
            int number = scanner.nextInt();
            changeOrder(students, index - number, index);
        }

        showStudents(students);
    }

    private static int[] initStudents(int numberOfStudent) {
        int[] students = new int[numberOfStudent];

        for (int index = 0; index < numberOfStudent; index++) {
            students[index] = index + 1;
        }

        return students;
    }

    protected static void changeOrder(int[] students, int start, int end) {
        int student = students[end];
        for (int index = end - 1; index >= start; index--) {
            students[index + 1] = students[index];
        }
        students[start] = student;
    }

    private static void showStudents(int[] students) {
        Arrays.stream(students)
                .forEach(student -> System.out.print(student + " "));
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 방배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            students.add(new Student(S, Y));
        }

        Collections.sort(students);

        int result = 0;
        int count = 1;
        Student lastStudent = students.get(0);
        for (int i = 1; i < N; i++) {
            if (lastStudent.equals(students.get(i))) {
                count++;
                continue;
            }

            result += calculateResult(count, K);
            count = 1;
            lastStudent = students.get(i);
        }
        result += calculateResult(count, K);

        System.out.println(result);
    }

    private static int calculateResult(int count, int k) {
        if (count % k > 0) {
            return (count / k) + 1;
        }
        return count / k;
    }

    static class Student implements Comparable<Student> {
        private final int gender;
        private final int grade;

        public Student(int gender, int grade) {
            this.gender = gender;
            this.grade = grade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return gender == student.gender && grade == student.grade;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, grade);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "gender=" + gender +
                    ", grade=" + grade +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            if (grade == o.grade) {
                return gender - o.gender;
            }
            return grade - o.grade;
        }
    }
}

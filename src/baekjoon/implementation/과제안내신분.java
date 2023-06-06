package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 과제안내신분 {
    private static final int NUMBER_OF_STUDENTS = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> students = new HashSet<>();
        for (int i = 0; i < NUMBER_OF_STUDENTS - 2; i++) {
            students.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= NUMBER_OF_STUDENTS; i++) {
            if (!students.contains(i)) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}

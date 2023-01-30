package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = n;

            Grade[] grades = getGrades(br, n);

            answer = checkGrade(answer, grades);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static Grade[] getGrades(BufferedReader br, int n) throws IOException {
        StringTokenizer st;
        Grade[] grades = new Grade[n];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grades[j] = new Grade(a, b);
        }
        return grades;
    }

    private static int checkGrade(int answer, Grade[] grades) {
        Arrays.sort(grades);
        int min = Integer.MAX_VALUE;
        for (Grade grade : grades) {
            if (min < grade.documentGrade) {
                answer--;
            } else {
                min = grade.documentGrade;
            }
        }
        return answer;
    }
}

class Grade implements Comparable<Grade> {
    int documentGrade;
    int interviewGrade;

    public Grade(int documentGrade, int interviewGrade) {
        this.documentGrade = documentGrade;
        this.interviewGrade = interviewGrade;
    }

    @Override
    public int compareTo(Grade o) {
        return this.interviewGrade-o.interviewGrade;
    }
}
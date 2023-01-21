package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();

        /**
         * 만약 주어진 식이 "10+20-30+40+50" 이라면 괄호를 "10+20-(30+40+50)"와 같이 만들어 최소값을 만들 수 있다.
         * 또한 "10+20-(30+40+50)" 식은 "10+20-30-40-50" 식으로 표현할 수 있다.
         * 이를 통해 알 수 있는 것은 처음으로 '-' 문자가 나온 뒤 모든 '+' 기호는 '-'로 바꾸면 주어진 문제의 답에 대한 식을 구할 수 있다.
         */
        char[] tmp = changeProblem(problem);

        /**
         * 위에서 바꾼 식이 만약 "10+20-30-40"이라 가정해보자.
         * 그럼 4개의 정수 값을 구할수 있다. (10, +20, -30, -40)
         * 이렇게 구해진 정수 값들을 그냥 더해주면 해당 문제에 대한 답을 구할 수 있다.
         */
        int answer = 0;
        problem = String.valueOf(tmp) + " "; //마지막 정수 값을 구하기 위해 빈문자열을 하나 추가해준다.
        StringBuilder sb = new StringBuilder();
        for (char check : problem.toCharArray()) {
            if (Character.isDigit(check)) {
                sb.append(check);
            } else {
                answer += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                sb.append(check);
            }
        }
        System.out.println(answer);
    }

    private static char[] changeProblem(String problem) {
        char[] tmp = problem.toCharArray();
        if (problem.contains("-")) {
            int i = problem.indexOf('-');
            for (int j = i + 1; j < tmp.length; j++) {
                if (tmp[j] == '+') {
                    tmp[j] = '-';
                }
            }
        }
        return tmp;
    }
}

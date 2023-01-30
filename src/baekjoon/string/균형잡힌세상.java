package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String answer = "";
        String str = "";
        while (!(str = br.readLine()).equals(".")) {
            answer = "yes";
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        answer = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        answer = "no";
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                answer = "no";
            }
            sb.append(answer).append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}

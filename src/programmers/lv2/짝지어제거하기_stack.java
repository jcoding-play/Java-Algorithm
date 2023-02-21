package programmers.lv2;

import java.util.Stack;

public class 짝지어제거하기_stack {
    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) answer = 1;
        return answer;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
}

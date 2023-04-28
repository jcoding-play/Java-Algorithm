package programmers.lv2;

import java.util.Stack;

public class 괄호회전하기 {

    public static final int OPEN_PARENTHESIS_INDEX = 0;
    public static final int CLOSE_PARENTHESIS_INDEX = 1;

    static char[][] pair = {{'(', ')'}, {'[', ']'}, {'{', '}'}};

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String source = getSource(s, i);

            if (validateParenthesis(source))
                answer++;
        }
        return answer;
    }

    private static String getSource(String s, int i) {
        return s.substring(i, s.length()) + s.substring(0, i);
    }

    private static boolean validateParenthesis(String source) {
        Stack<Character> stack = new Stack<>();
        for (char parenthesis : source.toCharArray()) {
            if (isOpenParenthesis(parenthesis)) {
                stack.push(parenthesis);
                continue;
            }

            if (isNotPairParenthesis(stack, getPairIndex(parenthesis)))
                return false;
        }
        if (!stack.isEmpty())
            return false;

        return true;
    }

    private static boolean isOpenParenthesis(char parenthesis) {
        return parenthesis == '(' || parenthesis == '[' || parenthesis == '{';
    }

    private static int getPairIndex(char parenthesis) {
        for (int index = 0; index < 3; index++) {
            if (parenthesis == pair[index][CLOSE_PARENTHESIS_INDEX]) {
                return index;
            }
        }
        return 0;
    }

    private static boolean isNotPairParenthesis(Stack<Character> stack, int pairIndex) {
        return stack.isEmpty() || stack.pop() != pair[pairIndex][OPEN_PARENTHESIS_INDEX];
    }

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}

package programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

    public static int[] solution(int[] numbers) {
        int len = numbers.length;

        int[] answer = new int[len];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            int number = numbers[i];

            while (!stack.isEmpty() && numbers[stack.peek()] < number) {
                answer[stack.pop()] = number;
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {9,2,10,10,11,1};
        for (int number : solution(numbers)) {
            System.out.println(number);
        }
    }
}

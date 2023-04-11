package programmers.lv2;

import java.util.Stack;

public class 주식가격_stack {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        stack.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = i - index - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}

package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public static int solution(int[] elements) {
        Set<Integer> answers = new HashSet<>();
        answers.add(calculateTotalSum(elements));

        int sizeOfElements = elements.length;
        for (int i = 1; i < sizeOfElements; i++) {
            for (int j = 0; j < sizeOfElements; j++) {
                int sum = getSum(elements, sizeOfElements, i, j);
                answers.add(sum);
            }
        }

        return answers.size();
    }

    private static int calculateTotalSum(int[] elements) {
        return Arrays.stream(elements)
                .sum();
    }

    private static int getSum(int[] elements, int sizeOfElements, int i, int j) {
        int count = 0;
        int index = j;
        int sum = 0;

        while (count < i) {
            sum += elements[index];
            count++;
            index++;

            if (index == sizeOfElements) {
                index = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }
}

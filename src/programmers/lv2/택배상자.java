package programmers.lv2;

import java.util.Stack;

public class 택배상자 {
    public static int solution(int[] order) {
        int answer = 0;
        int lastLoadedBox = 0;

        Stack<Integer> auxiliaryContainerBelt = new Stack<>();

        for (int boxNumber : order) {
            if (lastLoadedBox < boxNumber) {
                pushAuxiliaryContainerBelt(lastLoadedBox, boxNumber, auxiliaryContainerBelt);
                lastLoadedBox = boxNumber;
                answer++;
                continue;
            }
            if (lastLoadedBox > boxNumber) {
                if (isLastBoxInAuxiliaryContainerBelt(boxNumber, auxiliaryContainerBelt)) {
                    auxiliaryContainerBelt.pop();
                    answer++;
                    continue;
                }
                break;
            }
        }
        return answer;
    }

    private static void pushAuxiliaryContainerBelt(int lastLoadedBox, int boxNumber, Stack<Integer> auxiliaryContainerBelt) {
        for (int num = lastLoadedBox + 1; num < boxNumber; num++) {
            auxiliaryContainerBelt.push(num);
        }
    }

    private static boolean isLastBoxInAuxiliaryContainerBelt(int boxNumber, Stack<Integer> auxiliaryContainerBelt) {
        return auxiliaryContainerBelt.peek() == boxNumber;
    }

    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        System.out.println(solution(order));
    }
}

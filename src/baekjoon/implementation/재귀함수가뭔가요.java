package baekjoon.implementation;

import java.util.List;
import java.util.Scanner;

public class 재귀함수가뭔가요 {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        runRecursiveFunction(0, N);
    }

    private static void runRecursiveFunction(int count, int n) {
        if (count == n + 1) {
            return;
        }
        if (count == 0) {
            outputView.printStart();
        }
        outputView.printRecursiveFunction(count, n);
        runRecursiveFunction(count + 1, n);
        outputView.printEnd(count);
    }

    static class OutputView {
        private static final String PREFIX = "____";
        private static final String NEWLINE = System.lineSeparator();
        private static final String START_MESSAGE = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
        private static final String END_MESSAGE_FORMAT = "%s라고 답변하였지.\n";
        private static final String FIRST_MESSAGE = "\"재귀함수가 뭔가요?\"";
        private static final String SECOND_MESSAGE = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        private static final String THIRD_MESSAGE = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        private static final String FOURTH_MESSAGE = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        private static final String LAST_MESSAGE = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";

        public void printStart() {
            System.out.println(START_MESSAGE);
        }

        public void printRecursiveFunction(int count, int n) {
            List<String> messages = generateMessages(generatePrefix(count), count, n);
            printMessages(messages);
        }

        private String generatePrefix(int count) {
            return PREFIX.repeat(Math.max(0, count));
        }

        private List<String> generateMessages(String prefix, int count, int n) {
            if (count == n) {
                return List.of(prefix + FIRST_MESSAGE, prefix + LAST_MESSAGE);
            }
            return List.of(
                    prefix + FIRST_MESSAGE,
                    prefix + SECOND_MESSAGE,
                    prefix + THIRD_MESSAGE,
                    prefix + FOURTH_MESSAGE
            );
        }

        private void printMessages(List<String> messages) {
            System.out.println(String.join(NEWLINE, messages));
        }

        public void printEnd(int count) {
            System.out.printf(END_MESSAGE_FORMAT, generatePrefix(count));
        }
    }
}

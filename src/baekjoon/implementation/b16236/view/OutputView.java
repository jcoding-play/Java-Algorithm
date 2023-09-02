package baekjoon.implementation.b16236.view;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printTime(int time) {
        System.out.println(time);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}

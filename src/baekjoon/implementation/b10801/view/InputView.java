package baekjoon.implementation.b10801.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public String readNumbers() {
        return scanner.nextLine();
    }
}

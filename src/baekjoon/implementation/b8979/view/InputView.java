package baekjoon.implementation.b8979.view;

import baekjoon.implementation.b8979.view.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public String inputNAndK() {
        String input = scanner.nextLine();
        InputValidator.validateInput(input);

        return input;
    }

    public String inputCountryNameAndMedal() {
        String input = scanner.nextLine();
        InputValidator.validateInput(input);

        return input;
    }
}

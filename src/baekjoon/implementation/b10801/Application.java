package baekjoon.implementation.b10801;

import baekjoon.implementation.b10801.controller.MainController;
import baekjoon.implementation.b10801.view.InputView;
import baekjoon.implementation.b10801.view.OutputView;

public class Application {

    public static void main(String[] args) {
        MainController mainController = new MainController(inputView(), outputView());
        mainController.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}

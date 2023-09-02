package baekjoon.implementation.b16236.controller;

import baekjoon.implementation.b16236.domain.Board;
import baekjoon.implementation.b16236.domain.Shark;
import baekjoon.implementation.b16236.domain.TimeCalculator;
import baekjoon.implementation.b16236.view.InputView;
import baekjoon.implementation.b16236.view.OutputView;

import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        showTotalTime(initTimeCalculator());
    }

    private TimeCalculator initTimeCalculator() {
        Board board = repeatTemplate(this::initBoard);
        Shark shark = new Shark();

        return new TimeCalculator(board, shark);
    }

    private Board initBoard() {
        int n = repeatTemplate(inputView::inputN);
        int[][] board = repeatTemplate(() -> inputView.inputBoard(n));

        return new Board(board);
    }

    private void showTotalTime(TimeCalculator timeCalculator) {
        int time = timeCalculator.calculateTotalTime();
        outputView.printTime(time);
    }

    private <T> T repeatTemplate(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatTemplate(inputReader);
        }
    }
}

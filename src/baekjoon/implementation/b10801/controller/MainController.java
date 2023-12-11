package baekjoon.implementation.b10801.controller;

import baekjoon.implementation.b10801.domain.CardGame;
import baekjoon.implementation.b10801.domain.Player;
import baekjoon.implementation.b10801.domain.Round;
import baekjoon.implementation.b10801.view.InputView;
import baekjoon.implementation.b10801.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CardGame cardGame = initializeCardGame();
        showWinner(cardGame);
    }

    private CardGame initializeCardGame() {
        Player firstPlayer = initializePlayer();
        Player secondPlayer = initializePlayer();

        return new CardGame(firstPlayer, secondPlayer, new Round());
    }

    private Player initializePlayer() {
        String readNumbers = inputView.readNumbers();
        List<Integer> numbers = toIntegerList(readNumbers);

        return new Player(numbers);
    }

    private List<Integer> toIntegerList(String readNumbers) {
        return Arrays.stream(readNumbers.split(" "))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void showWinner(CardGame cardGame) {
        String winner = cardGame.findGameWinner();
        outputView.printWinner(winner);
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

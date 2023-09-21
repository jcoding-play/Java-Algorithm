package baekjoon.implementation.b8979.controller;

import baekjoon.implementation.b8979.domain.Countries;
import baekjoon.implementation.b8979.domain.Country;
import baekjoon.implementation.b8979.domain.Medal;
import baekjoon.implementation.b8979.utils.Constants;
import baekjoon.implementation.b8979.view.InputView;
import baekjoon.implementation.b8979.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String nAndK = inputView.inputNAndK();
        String[] split = nAndK.split(Constants.DELIMITER);

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        Countries countries = new Countries(initCountries(N));

        outputView.printRanking(countries.findRankingOf(K));
    }

    private List<Country> initCountries(int N) {
        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = inputView.inputCountryNameAndMedal();
            String[] split = input.split(Constants.DELIMITER);

            countries.add(generateCountry(split));
        }

        return countries;
    }

    private Country generateCountry(String[] split) {
        int countryName = Integer.parseInt(split[0]);
        Medal medal = initMedal(split);

        return new Country(countryName, medal);
    }

    private Medal initMedal(String[] source) {
        int gold = Integer.parseInt(source[1]);
        int silver = Integer.parseInt(source[2]);
        int bronze = Integer.parseInt(source[3]);

        return new Medal(gold, silver, bronze);
    }
}

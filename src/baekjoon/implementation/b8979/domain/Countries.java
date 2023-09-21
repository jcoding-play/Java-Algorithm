package baekjoon.implementation.b8979.domain;

import java.util.*;

public class Countries {
    private static final int MIN_COUNTRIES_SIZE = 1;

    private final List<Country> countries;

    public Countries(List<Country> countries) {
        validateCountries(countries);
        this.countries = countries;
    }

    private void validateCountries(List<Country> countries) {
        if (countries.size() < MIN_COUNTRIES_SIZE) {
            throw new IllegalArgumentException("올림픽에 참여하는 나라는 최소 1이상이어야 합니다.");
        }
    }

    public int findRankingOf(int countryName) {
        Map<Integer, Integer> rankings = findRankings();
        return rankings.get(countryName);
    }

    public Map<Integer, Integer> findRankings() {
        Collections.sort(countries);

        Map<Integer, Integer> rankings = new LinkedHashMap<>();

        for (int currentCountryIndex = 0; currentCountryIndex < countries.size(); currentCountryIndex++) {
            Country currentCountry = countries.get(currentCountryIndex);
            int ranking = calculateRanking(currentCountry, currentCountryIndex);

            rankings.put(currentCountry.getCountryName(), ranking);
        }
        return rankings;
    }

    private int calculateRanking(Country currentCountry, int currentCountryIndex) {
        int ranking = 1;

        for (int nextCountryIndex = currentCountryIndex - 1; nextCountryIndex >= 0; nextCountryIndex--) {
            Country nextCountry = countries.get(nextCountryIndex);
            if (currentCountry.hasSameMedal(nextCountry)) {
                continue;
            }

            ranking += (nextCountryIndex + 1);
            break;
        }
        return ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries1 = (Countries) o;
        return Objects.equals(countries, countries1.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countries);
    }
}

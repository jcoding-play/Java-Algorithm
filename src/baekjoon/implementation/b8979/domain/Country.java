package baekjoon.implementation.b8979.domain;

import java.util.Objects;

public class Country implements Comparable<Country> {
    private static final int MIN_NUMBER_OF_COUNTRY_NAME = 1;

    private final int countryName;
    private final Medal medal;

    public Country(int countryName, Medal medal) {
        validateCountryName(countryName);

        this.countryName = countryName;
        this.medal = medal;
    }

    private void validateCountryName(int countryName) {
        if (countryName < MIN_NUMBER_OF_COUNTRY_NAME) {
            throw new IllegalArgumentException("나라의 이름은 최소 1이상이어야 합니다.");
        }
    }

    public boolean hasSameMedal(Country country) {
        return country.isMatchMedal(medal);
    }

    private boolean isMatchMedal(Medal medal) {
        return this.medal.equals(medal);
    }

    public int getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryName == country.countryName && Objects.equals(medal, country.medal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, medal);
    }

    @Override
    public int compareTo(Country other) {
        return this.medal.compareTo(other.medal);
    }
}
